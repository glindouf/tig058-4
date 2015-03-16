package club.db;

import club.domain.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author phcr
 */
public class Query {
    
    static public Connector connector;

    public static Member getMemberWithId(String id) {
       Member m = new Member();
       try {
           Statement stmnt = connector.connection.createStatement();
           String query = String.format("SELECT * FROM member where id='%s'", id);
           ResultSet rs = stmnt.executeQuery(query);
           
           while (rs.next()) {
               m.setId(rs.getString("id"));
               m.setGivenname(rs.getString("givenname"));
               m.setSurname(rs.getString("surname"));
               m.setEmail(rs.getString("email"));
               m.setGender(rs.getInt("gender"));
               m.setBirthdate(rs.getLong("birthdate"));
               m.setJoindate(rs.getLong("joindate"));
               m.setActive(rs.getBoolean("active"));
           }
       } catch (SQLException e) {
           System.out.println(e);
       }
       return m;
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
    
    public static ArrayList<Member> getParentsForMember (String id) {
        ArrayList<Member> am = new ArrayList<Member>();
        
        try {
            Statement stmnt = connector.connection.createStatement();
            String query = String.format("SELECT member.* FROM member" 
                    + " join(select parent.id from parent where parent.childid='%s') as pid"
                    + " on (pid.id=member.id)", id);
   
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getString("id"));
                m.setGivenname(rs.getString("givenname"));
                m.setSurname(rs.getString("surname"));
                m.setEmail(rs.getString("email"));
                m.setGender(rs.getInt("gender"));
                m.setBirthdate(rs.getLong("birthdate"));
                m.setJoindate(rs.getLong("joindate"));
                m.setActive(rs.getBoolean("active"));
                am.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }        
        return am;
    }
    
}
