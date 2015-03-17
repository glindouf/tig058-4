package club.db;

import club.domain.Member;
import club.domain.register.Register;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author phcr
 */
public class Query {
    
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
    
    /** Insert **/    
    public static boolean insertMember(Register m) {
        try {
            Statement stmnt = Connector.connection.createStatement();
            int active = (m.isActive()) ? 1 : 0;
            String insertquery = String.format("INSERT INTO member values(%s,%s,%s,%s,%d,%d,%d,%d)",
                    m.getId(), m.getGivenname(), m.getSurname(), m.getEmail(), m.getGender(), m.getBirthdate(), m.getJoindate(), active);
            
            String teamquery = String.format("INSERT INTO team_members values(%s,%s)", m.getTeam(), m.getId());
            stmnt.executeQuery(insertquery);
            
            
            
            
            
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    /** Update **/
    public static boolean updateMember(Register m) {        
        try {
            int active = (m.isActive()) ? 1 : 0;
            Statement stmnt = Connector.connection.createStatement();
            String query = String.format("UPDATE member SET givenname='%s', "
                    + "surname='%s', email='%s', gender=%d, birthdate=%d, "
                    + "joindate=%s, active=%d WHERE id = '%s'",
                    m.getGivenname(), m.getSurname(),
                    m.getEmail(), m.getGender(), m.getBirthdate(), 
                    m.getJoindate(), active, m.getId());
        } catch (SQLException e) {            
            return false;            
        }        
        return true;
    }
    
    
    /** Search **/
    
    public static Member getMemberWithId(String id) {
       Member m = new Member();
       try {
           Statement stmnt = Connector.connection.createStatement();
           String query = String.format("SELECT * FROM member WHERE id='%s'", id);
           ResultSet rs = stmnt.executeQuery(query);
           
           while (rs.next()) {
               m = memberFromRS(rs);
           }
       } catch (SQLException e) {
           System.out.println(e);
       }
       return m;
    }
    
    public static ArrayList<Member> getMemberWithSurname(String surname) {
        ArrayList<Member> am = new ArrayList<>();
        try {
            Statement stmnt = Connector.connection.createStatement();
            String query = String.format("SELECT * FROM member WHERE surname='%s'", surname);
            ResultSet rs = stmnt.executeQuery(query);
            
            while (rs.next()) {
                am.add(memberFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return am;
    }
    
    public static ArrayList<Member> getAllMembers() {    
        ArrayList<Member> members = new ArrayList<>();
        try{
            Statement stmnt = Connector.connection.createStatement();
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
        ArrayList<String> team = new ArrayList<>();
        try {
            Statement stmnt = Connector.connection.createStatement();
            String query = String.format("SELECT team FROM team_members WHERE mid='%s'", id);
            
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
            Statement stmnt = Connector.connection.createStatement();
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
            Statement stmnt = Connector.connection.createStatement();
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
            Statement stmnt = Connector.connection.createStatement();
            String query = String.format("SELECT id FROM coach WHERE id='%s'", id);
            
            ResultSet rs = stmnt.executeQuery(query);
            
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return b;
    }
    
    public static ArrayList<Member> getMembersForTeam(String team) {
        ArrayList<Member> tm = new ArrayList<>();
        try {
            Statement stmnt = Connector.connection.createStatement();
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
        ArrayList<Member> cm = new ArrayList<>();
        try {
            Statement stmnt = Connector.connection.createStatement();
            String query = String.format("SELECT * FROM member "
                    + "JOIN (SELECT id FROM coach WHERE team='%s') AS c ON (c.id=member.id)", team);
            
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                cm.add(memberFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cm;
    }
    
    public static ArrayList<Member> getParentsForMember (String id) {
        ArrayList<Member> am = new ArrayList<>();
        
        try {
            Statement stmnt = Connector.connection.createStatement();
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
        ArrayList<Member> am = new ArrayList<>();
        
        try {
            Statement stmnt = Connector.connection.createStatement();
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
        ArrayList<String> ts = new ArrayList<>();
        
        try {
            Statement stmnt = Connector.connection.createStatement();
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
}
