
package club;

import club.comparator.MemberSurnameComparator;
import club.db.Connector;
import club.db.Query;
import club.domain.Member;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

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
            
            System.out.println(Query.isParent(m.getId()));
            System.out.println(Query.isChild(m.getId()));
            System.out.println(Query.isCoach(m.getId()));
            
            ArrayList<Member> parents = Query.getParentsForMember(m.getId());            
            for (Member p : parents) {
                System.out.println(p.toString());
            }
            
            
            System.out.println("D> " + Query.getAllMemberId(m.getId()));
            
            Collections.sort(Query.getAllMembers(), new MemberSurnameComparator());
            
            System.out.println(Query.getMembersAndCoachFromTeam("D"));
            
        } catch (SQLException e) {
            System.out.println(e);
        }            
    }
}
