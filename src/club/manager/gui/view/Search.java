
package club.manager.gui.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author johannes
 */
public class Search extends JFrame implements ActionListener{
    
    JPanel panel;
    JPanel topPanel;
    GridLayout grid; 
    
    JPanel srchMember;
    JPanel srchCoach;
    JPanel sortMember;
    JPanel listTeams;
    
    //JButtons used by class
    JButton srchMemberBtn;
    JButton srchCoachBtn;
    JButton sortMemberBtn;
    JButton listTeamsBtn;    
    
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
        
        panel    = new JPanel(new BorderLayout());
        topPanel = new JPanel(new GridLayout(2, 2));
        
        panel.add(topPanel, BorderLayout.NORTH);
        
        srchMemberBtn = new JButton("Search for \n member");
        srchCoachBtn  = new JButton("Search for \n coach in team");
        sortMemberBtn = new JButton("Sort members \n (ID or Surname)");
        listTeamsBtn  = new JButton("Search for \n information on Team");
        
        topPanel.add(srchMemberBtn);
        topPanel.add(srchCoachBtn);
        topPanel.add(sortMemberBtn);
        topPanel.add(listTeamsBtn);
        
        add(panel);
        
        pack();       
        
        
        setTitle("Search");
        setVisible(true); 
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
         srchMemberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchMemberBtn.setVisible(true);
                           
            }
        });
         
        sortMemberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchMemberBtn.setVisible(true);
                           
            }
        });
        
        srchCoachBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchCoachBtn.setVisible(true);
                           
            }
        });
        
        listTeamsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchMemberBtn.setVisible(true);
                           
            }
        });
        
         listTeamsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchMemberBtn.setVisible(true);
                           
            }
        });
         
         listTeamsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                srchMemberBtn.setVisible(true);
                           
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
         
}
