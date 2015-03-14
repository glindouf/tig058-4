
package club.manager.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author johannes
 */
public class Registry extends JFrame implements ActionListener {
    
    private JButton newMemb    = new JButton();
    private JButton updateMemb = new JButton();
          
    public Registry()	{
      
        initUI();
    }
    
    /*
    Elements used in constructor
    */
    public final void initUI() {   
        setTitle("Registry");
        setVisible(true); 
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         
        
            
    }
}
