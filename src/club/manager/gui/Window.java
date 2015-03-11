//package club.manager.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Window extends JFrame {

    public Window()	{
        initUI();
    }

    private void initUI()	{

        setTitle("");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    

    public static void main (String [] args) {

        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                Window ex = new Window();
                ex.setVisible(true);
            }
        });
    }
}