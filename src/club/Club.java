
package club;

import club.manager.gui.Window;

import club.db.Connector;
import club.db.Query;
import club.domain.Member;
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
        Window.StartGUI();
        try {
            Connector.connection = DriverManager.getConnection("jdbc:sqlite:club.db");            
        } catch (SQLException e) {
            System.out.println(e);
        }            
    }
}
