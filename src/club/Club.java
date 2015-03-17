
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
            Connector.connection = DriverManager.getConnection("jdbc:sqlite:club.db");            
        } catch (SQLException e) {
            System.out.println(e);
        }            
    }
}
