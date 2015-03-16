
package club;

import club.db.Connector;
import club.db.Query;
import club.domain.Member;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phcr
 */
public class Club {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Query.connector = new Connector(DriverManager.getConnection("jdbc:sqlite:club.db")); 
            Member m = Query.getMemberWithId("000101-9213");
            System.out.println(m.toString());
            System.out.println(Query.isParent(m.getId()));
            System.out.println(Query.isChild(m.getId()));
            System.out.println(Query.isCoach(m.getId()));
            
            ArrayList<Member> parents = Query.getParentsForMember(m.getId());
            
            for (Member p : parents) {
                System.out.println(p.toString());
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }            
    }
}
