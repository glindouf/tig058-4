package club.manager.gui;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {   
    
    JButton reg = new JButton("Registervård");
    JButton search = new JButton("Sökare");
    
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
    /*
    Call to initialize GUI
    */
    public static void guiStart() {
    EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                Window w = new Window();
                w.setVisible(true);
            }
        });
    }
}
