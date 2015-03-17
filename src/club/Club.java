
package club;

import club.manager.gui.Window;

import club.db.Connector;
import club.db.Query;
import club.domain.Member;
import club.manager.gui.Manager;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        try {
            Connector.connection = DriverManager.getConnection("jdbc:sqlite:club.db");         
            Manager.start();
        } catch (SQLException e) {
            System.out.println(e);
        }            
    }
}
