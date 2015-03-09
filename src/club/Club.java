/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club;

import club.db.Connector;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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
        try {
            c = new Connector(DriverManager.getConnection("jdbc:sqlite:hello.db"));
            Statement stmnt = c.connection.createStatement();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        
    }
    
}
