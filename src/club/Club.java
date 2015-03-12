
package club;

import club.db.Connector;
import club.domain.Member;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import club.manager.gui.Window;


/**
 *
 * @author phcr
 */
public class Club {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connector c;
        
        Window.guiStart();
        
        try {
            c = new Connector(DriverManager.getConnection("jdbc:sqlite:club.db"));
            Statement stmnt = c.connection.createStatement();
            
            ResultSet rs = stmnt.executeQuery("select * from member where id=1");
            
            ArrayList<Member> members = new ArrayList<Member>();
            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setGivenname(rs.getString("givenname"));
                m.setSurname(rs.getString("surname"));
                m.setEmail(rs.getString("email"));
                m.setGender(rs.getInt("gender"));
                m.setBirthdate(rs.getLong("birthdate"));
                m.setJoindate(rs.getLong("joindate"));
                m.setActive(rs.getBoolean("active"));
                members.add(m);
            }
            for (Member m : members) {
                System.out.println(m.getId());
                System.out.println(m.getGivenname());
                System.out.println(m.getSurname());
                System.out.println(m.getEmail());
                System.out.println(m.getGender());
                System.out.println(m.getBirthdate());
                System.out.println(m.getJoindate());
                System.out.println(m.isActive());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }                
        
    }
    
}
