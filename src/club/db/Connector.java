
package club.db;

import java.sql.Connection;

/**
 *
 * @author phcr
 */
public class Connector {
    
    public static Connection connection;
    
    public Connector (Connection c) {
        if (Connector.connection == null) {
            Connector.connection = c;
        }
    }

    public static Connection getC() {
        return connection;
    }
}
