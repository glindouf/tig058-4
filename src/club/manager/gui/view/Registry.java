
package club.manager.gui.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        final JPanel lowerPanel    = new JPanel();
        
         //JTextFields used by class
        JTextField idText = new JTextField("");
        JTextField givenNameText = new JTextField("");
        JTextField familyNameText = new JTextField("");
        JTextField emailText = new JTextField("");
        JTextField birthText = new JTextField("");
        JTextField memberSinceText = new JTextField("");
                       
        
        //JButtons used by class
        JButton addMembBtn     = new JButton("Add Member");
        JButton updateMembBtn  = new JButton("Update Member");
        JButton backBtn        = new JButton("Back");
        JButton submitBtn      = new JButton("Submit");
        
        //JCheckBoxes used by class
        JCheckBox activeCheckBox = new JCheckBox(""); 
        
        //JComboBoxes used by class
        String [] genders = {"Choose gender...", "Female", "Male"};
        JComboBox<String> genderCombo = new JComboBox<String>(genders);  
        
        //JLabels used by class
        JLabel idLabel         = new JLabel(" Personnummer:"); 
        JLabel givenNameLabel  = new JLabel("     Förnamn:");
        JLabel familyNameLabel = new JLabel("   Efternamn:");
        JLabel emailLabel      = new JLabel("       Email:");
        JLabel genderLabel     = new JLabel("     Gender:");
        JLabel birthLabel      = new JLabel("     Birthdate:");
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
                .addComponent(emailText).addComponent(genderCombo).addComponent(birthText)
                .addComponent(memberSinceText).addComponent(activeCheckBox));  
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
            addComponent(genderLabel).addComponent(genderCombo));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(birthLabel).addComponent(birthText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(memberSinceLabel).addComponent(memberSinceText));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(activeLabel).addComponent(activeCheckBox));
        layout.setVerticalGroup(vGroup);
                     
        panel.add(flowPanel, BorderLayout.NORTH);
        panel.add(groupPanelAdd, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);
        
        flowPanel.add(addMembBtn);
        flowPanel.add(updateMembBtn);
        lowerPanel.add(backBtn);
        lowerPanel.add(submitBtn);
        groupPanelAdd.setVisible(false);
        lowerPanel.setVisible(false);
      
        add(panel);
        
        pack();
        
         /*
        ActionListener for "Add Member" Button.
        */
        addMembBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                groupPanelAdd.setVisible(true);
                lowerPanel.setVisible(true);
           
            }
        });
        
         /*
        ActionListener for "Add Member" Button.
        */
        updateMembBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              
                groupPanelAdd.setVisible(true);
                lowerPanel.setVisible(true);
           
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
