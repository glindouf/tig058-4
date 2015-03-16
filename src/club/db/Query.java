package club.db;

import club.domain.Member;
import club.domain.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author phcr
 */
public class Query {
    
    static public Connector connector;

    public static Member memberFromRS(ResultSet rs) throws SQLException {
        Member m = new Member();
        m.setId(rs.getString("id"));
        m.setGivenname(rs.getString("givenname"));
        m.setSurname(rs.getString("surname"));
        m.setEmail(rs.getString("email"));
        m.setGender(rs.getInt("gender"));
        m.setBirthdate(rs.getLong("birthdate"));
        m.setJoindate(rs.getLong("joindate"));
        m.setActive(rs.getBoolean("active"));
        return m;
    }
    
    public static Member getMemberWithId(String id) {
       Member m = new Member();
       try {
           Statement stmnt = connector.connection.createStatement();
           String query = String.format("SELECT * FROM member where id='%s'", id);
           ResultSet rs = stmnt.executeQuery(query);
           
           while (rs.next()) {
               m = memberFromRS(rs);
           }
       } catch (SQLException e) {
           System.out.println(e);
       }
       return m;
    }
    
    public static ArrayList<Member> getAllMembers() {    
        ArrayList<Member> members = new ArrayList<Member>();
        try{
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT * FROM member");
            
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                members.add(memberFromRS(rs));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return members;
    }
    
    public static ArrayList<String> getMemberTeamWithId(String id) {
        ArrayList<String> team = new ArrayList<String>();
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT team FROM team_members where mid='%s'", id);
            
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                team.add(rs.getString("team"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return team;
    }
    
    public static boolean isParent (String id) {
        boolean b = false;
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT id FROM parent WHERE id='%s'", id);
            
            ResultSet rs = stmnt.executeQuery(query);
            
            return rs.next();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return b;
    }
    
    public static boolean isChild (String id) {
        boolean b = false;
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT id FROM child WHERE id='%s'", id);
            
            ResultSet rs = stmnt.executeQuery(query);
            
            return rs.next();
        } catch (SQLException e) {
            
        }
        return b;
    }
    
    public static boolean isCoach (String id) {
        boolean b = false;
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT id FROM coach WHERE id='%s'", id);
            
            ResultSet rs = stmnt.executeQuery(query);
            
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return b;
    }
    
    public static ArrayList<Member> getMembersForTeam(String team) {
        ArrayList<Member> tm = new ArrayList<Member>();
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT * FROM member "
                    + "JOIN (team_members) ON (team='%s' AND mid=member.id)"
                    + "WHERE member.id NOT IN (select id from parent) AND"
                    + "(select id from coach)", team);
            
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                tm.add(memberFromRS(rs));
            }            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tm;
    }
    
    public static ArrayList<Member> getCoachesForTeam(String team) {
        ArrayList<Member> cm = new ArrayList<Member>();
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT * from member "
                    + "join (select mid from coach where team='%s') on (coach.mid=member.id)", team);
            
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                cm.add(memberFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cm;
    }
    
    public static Dictionary getMembersAndCoachFromTeam(String team) {
        Dictionary d = new Hashtable();
        
        ArrayList<Member> members = new ArrayList<Member>();
        ArrayList<Member> coaches = new ArrayList<Member>();
        
        members = getMembersForTeam(team);
        coaches = getCoachesForTeam(team);
        
        d.put("members", members);
        d.put("coaches", coaches);
        
        return d;
    }
    
    public static ArrayList<Member> getParentsForMember (String id) {
        ArrayList<Member> am = new ArrayList<Member>();
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT member.* FROM member" 
                    + " join(select parent.id from parent where parent.childid='%s') as pid"
                    + " on (pid.id=member.id)", id);
   
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                am.add(memberFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }        
        return am;
    }
    
    public static ArrayList<Member> getChildrenForMember (String id) {
        ArrayList<Member> am = new ArrayList<Member>();
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT member.* FROM member" 
                    + " join(select child.id from child where child.parentid='%s') as cid"
                    + " on (cid.id=member.id)", id);
   
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                am.add(memberFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }        
        return am;
    }
    
    public static ArrayList<String> getCoachTeams (String id) {
        ArrayList<String> ts = new ArrayList<String>();
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT distinct cid.team FROM member" 
                    + " join(select coach.id from coach where coach.id='%s') as cid"
                    + " on (cid.id=member.id)", id);
   
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                ts.add(rs.getString("team"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }        
        return ts;
    }
       
    
    public static Dictionary getAllMemberId(String id) {
        Dictionary d = new Hashtable();
        Member m = new Member();
        ArrayList<String> teams = null;
        ArrayList<Member> children = null;
        ArrayList<Member> parents = null;
        ArrayList<String> coacht = null;
        
        
        m = getMemberWithId(id);
        teams = getMemberTeamWithId(id);
        
        d.put("member", m);
        d.put("team", teams);
        
        if (isChild(id)) {
            parents = getParentsForMember(id);
            d.put("parents", parents);
        } else if (isParent(id)) {
            children = getChildrenForMember(id);
            d.put("children", children);
        } else if (isCoach(id)) {
            coacht = getCoachTeams(id);           
            d.put("coachteams", coacht);        
        }                
        
        return d;
    }
    
}
