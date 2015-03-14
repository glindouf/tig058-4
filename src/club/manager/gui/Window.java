package club.manager.gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

    public Window() {

        initUI();
    }

    private void initUI() {
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JButton registryBtn = new JButton("Registry");
        JButton searchBtn   = new JButton("Search");
                       
        panel.add(registryBtn, BorderLayout.WEST);
        panel.add(searchBtn, BorderLayout.EAST);
        
        add(panel);
        
        pack();
        
        registryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Registry reg = new Registry();
                
            }
        });
        
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