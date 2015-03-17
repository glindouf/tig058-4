
package club.manager.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author johannes
 */
public class Search extends JFrame implements ActionListener{
    
  /*
    Elements used in constructor
    */
    public Search() {
             
        initUI();
                 
    }
       
     /*
    Elements used in constructor
    */
    public final void initUI() {   
        setTitle("Search");
        setVisible(true); 
        //setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
    }
    
}
