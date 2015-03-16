
package club.manager.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author johannes
 */
public class Registry extends JFrame implements ActionListener {   
   
    public Registry()	{
        
        setVisible(true);
        initUI();
    }
    
    /*
    Elements used in constructor
    */
    public final void initUI() { 
        
        //JComponents used by class
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel flowPanel = new JPanel(new FlowLayout());
        final JPanel groupPanelAdd = new JPanel();
        
         //JTextFields used by class
        JTextField idText = new JTextField("");
        JTextField givenNameText = new JTextField("");
        JTextField familyNameText = new JTextField("");
        JTextField emailText = new JTextField("");
        JTextField genderText = new JTextField("");
        JTextField birthText = new JTextField("");
        JTextField memberSinceText = new JTextField("");
        JTextField activeText = new JTextField("");
        
        
        //JButtons used by class
        JButton addMembBtn    = new JButton("Add Member");
        JButton updateMembBtn = new JButton("Update Member");
        
        //JLabels used by class
        JLabel idLabel         = new JLabel("          ID:"); 
        JLabel givenNameLabel  = new JLabel("     Förnamn:");
        JLabel familyNameLabel = new JLabel("   Efternamn:");
        JLabel emailLabel      = new JLabel("       Email:");
        JLabel genderLabel     = new JLabel("     Förnamn:");
        JLabel birthLabel      = new JLabel("     Förnamn:");
        JLabel memberSinceLabel= new JLabel("Member Since:");
        JLabel activeLabel     = new JLabel("      Active:");
        
        // Settings for GroupLayout
        GroupLayout layout = new GroupLayout(groupPanelAdd);
        layout.setAutoCreateContainerGaps(true);
        groupPanelAdd.setLayout(layout);
        layout.setAutoCreateGaps(true);
        
        //Groups rows in UI horizontally (GroupLayout)
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
                
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(idLabel).addComponent(givenNameLabel).addComponent(familyNameLabel)
                .addComponent(emailLabel).addComponent(genderLabel).addComponent(birthLabel)
                .addComponent(memberSinceLabel).addComponent(activeLabel));      
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(idText).addComponent(givenNameText).addComponent(familyNameText)
                .addComponent(emailText).addComponent(genderText).addComponent(birthText)
                .addComponent(memberSinceText).addComponent(activeText));  
        layout.setHorizontalGroup(hGroup);
        
        //Groups rows in UI Vertically (GroupLayout)
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();  
        
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(idLabel).addComponent(idText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(givenNameLabel).addComponent(givenNameText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(familyNameLabel).addComponent(familyNameText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(emailLabel).addComponent(emailText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(genderLabel).addComponent(genderText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(birthLabel).addComponent(birthText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(memberSinceLabel).addComponent(memberSinceText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(activeLabel).addComponent(activeText));
        layout.setVerticalGroup(vGroup);
                     
        panel.add(flowPanel, BorderLayout.NORTH);
        panel.add(groupPanelAdd, BorderLayout.CENTER);
        
        flowPanel.add(addMembBtn);
        flowPanel.add(updateMembBtn);
        groupPanelAdd.setVisible(false);
      
        add(panel);
        
        pack();
        
         /*
        ActionListener for "Add Member" Button.
        */
        addMembBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                groupPanelAdd.setVisible(true);
           
            }
        });
        
        setTitle("Registry");
        panel.setVisible(true); 
        //flowPanel.setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         
        
            
    }
}
