package club.manager.gui.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

    public Window() {
        initWindow();
    }

    /*
    All the statements used in constructor.
    */
    private void initWindow() {
        
        JPanel panel  = new JPanel(new BorderLayout(100, 100));
        JPanel fPanel = new JPanel(new FlowLayout());
                 
        JButton registryBtn = new JButton("Registry");
        JButton searchBtn   = new JButton("Search");
        
        panel.add(fPanel, BorderLayout.NORTH);
        fPanel.add(registryBtn);
        fPanel.add(searchBtn);       
        
        add(panel);
        
        pack();
        
        /*
        ActionListener for Registry Button.
        */
        registryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Registry reg = new Registry();
                
            }
        });
        
        /*
        ActionListener for Search Button.
        @param 
        */
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Search srch = new Search();
            }
        });
        
        setTitle("Club");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    /*
    Called upon to start the GUI.
    */
    public static void StartGUI() {

       EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                Window w = new Window();
                w.setVisible(true);
            }
        });
    }
}