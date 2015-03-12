package club.manager.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {   
    
    JButton reg = new JButton("Registervård");
    JButton search = new JButton("Registervård");
    
    /*
    Passed contents of constructor to separate method "initUI"
    */
    public Window()	{
        initUI();
    }
    
    /*
    Elements used in constructor
    */
    public final void initUI()	{
     
        JPanel panel = new JPanel();   
        
        setTitle("Club Manager");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.add(reg);
        panel.add(search);
        
        this.add(panel);
    }
}
