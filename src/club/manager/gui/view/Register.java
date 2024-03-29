package club.manager.gui.view;

import club.db.Query;
import club.domain.Member;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author phcr
 */
public class Register extends javax.swing.JPanel {

    public club.domain.register.Register model;
    public SimpleDateFormat df;

    /**
     * Creates new form Register
     */
    public Register() {        
        this.model = new club.domain.register.Register();
        this.df = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
    }
    
    public void toggleRoles(Integer role) {
        int index = this.model.getRoles().indexOf(role);
        if (index == -1) {                
            this.model.getRoles().add(role);
        } else {
            this.model.getRoles().remove(index);        
        }        
        System.out.println(this.model.getRoles());
    }
    
    /**
     * Displays error messages.
     * @param text - The text to display in an JOptionPane.
     */
    public void displayError(String text) {
        JOptionPane.showMessageDialog(this, text,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
     /**
     * Redraws the ComboBox with teams, with a brand new collection of teams.
     */
    public void redrawTeamSelect() {
        teamSelect.removeAllItems();
        teamSelect.addItem("");
        for (String s : Query.getAllTeams()) {
            teamSelect.addItem(s);
        }
    }
    
    public void resetForm() {
        this.model = new club.domain.register.Register();
        
        idField.setText("");
        givennameField.setText("");
        surnameField.setText("");
        emailField.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        birthdateField.setText("");
        joindateField.setText("");
        activeCheckBox.setSelected(false);
        childCheckBox.setSelected(false);
        parentCheckBox.setSelected(false);
        coachCheckBox.setSelected(false);
        redrawTeamSelect();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        givennameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        birthdateField = new javax.swing.JTextField();
        joindateField = new javax.swing.JTextField();
        activeCheckBox = new javax.swing.JCheckBox();
        childCheckBox = new javax.swing.JCheckBox();
        parentCheckBox = new javax.swing.JCheckBox();
        coachCheckBox = new javax.swing.JCheckBox();
        teamSelect = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        addTeamField = new javax.swing.JTextField();
        addTeamButton = new javax.swing.JButton();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();

        jTextField5.setText("jTextField5");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Givenname");

        jLabel3.setText("Surname");

        jLabel4.setText("Email");

        jLabel5.setText("Gender");

        jLabel6.setText("Birthdate");

        jLabel7.setText("Joindate");

        jLabel8.setText("Active");

        jLabel9.setText("Role(s)");

        jLabel10.setText("Team");

        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFieldFocusLost(evt);
            }
        });

        givennameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                givennameFieldFocusLost(evt);
            }
        });

        surnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                surnameFieldFocusLost(evt);
            }
        });

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        birthdateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                birthdateFieldFocusLost(evt);
            }
        });

        joindateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                joindateFieldFocusLost(evt);
            }
        });

        activeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeCheckBoxActionPerformed(evt);
            }
        });

        childCheckBox.setText("Child");
        childCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childCheckBoxActionPerformed(evt);
            }
        });

        parentCheckBox.setText("Parent");
        parentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentCheckBoxActionPerformed(evt);
            }
        });

        coachCheckBox.setText("Coach");
        coachCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachCheckBoxActionPerformed(evt);
            }
        });

        redrawTeamSelect();
        teamSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamSelectActionPerformed(evt);
            }
        });

        jLabel11.setText("Add team");

        addTeamButton.setText("Add");
        addTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleRadioButton);
        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleRadioButton);
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(joindateField)
                                .addComponent(birthdateField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(surnameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(givennameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(activeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41)
                                .addComponent(childCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(parentCheckBox))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(52, 52, 52)
                                .addComponent(teamSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coachCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addTeamField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTeamButton))
                    .addComponent(submitButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(maleRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(femaleRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(givennameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(birthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(joindateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(activeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(childCheckBox)
                    .addComponent(parentCheckBox)
                    .addComponent(coachCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(teamSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(addTeamField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTeamButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            club.manager.gui.controller.Register.RegisterMember(this.model);
            resetForm();
        } catch (Exception ex) {
            this.displayError(ex.getMessage());            
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void addTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamButtonActionPerformed
        try {
            if (!addTeamField.getText().equals("")) {
                Query.insertTeam(addTeamField.getText());
                addTeamField.setText("");
                this.redrawTeamSelect();
            } else {
                this.displayError("New team field must have a value before adding a new team.");
            }
        } catch (SQLException e) {
            this.displayError(e.getMessage());
        }
    }//GEN-LAST:event_addTeamButtonActionPerformed

    private void idFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFieldFocusLost
        this.model.setId(idField.getText());
    }//GEN-LAST:event_idFieldFocusLost

    private void givennameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_givennameFieldFocusLost
        this.model.setGivenname(givennameField.getText());        
    }//GEN-LAST:event_givennameFieldFocusLost

    private void surnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameFieldFocusLost
        this.model.setSurname(surnameField.getText());        
    }//GEN-LAST:event_surnameFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        this.model.setEmail(emailField.getText());        
    }//GEN-LAST:event_emailFieldFocusLost

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        this.model.setGender(Member.Gender.Male.ordinal());
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        this.model.setGender(Member.Gender.Female.ordinal());
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void birthdateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_birthdateFieldFocusLost
        try {
            Date d = this.df.parse(birthdateField.getText());
            long time = d.getTime();
            this.model.setBirthdate(time);
        } catch (ParseException ex) {
            this.displayError("Invalid date format, the format is: yyyy-MM-dd");            
        }        
    }//GEN-LAST:event_birthdateFieldFocusLost

    private void joindateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_joindateFieldFocusLost
        try {
            Date d = this.df.parse(joindateField.getText());
            long time = d.getTime();
            this.model.setBirthdate(time);
        } catch (ParseException ex) {
            this.displayError("Invalid date format, the format is: yyyy-MM-dd");            
        }
    }//GEN-LAST:event_joindateFieldFocusLost

    private void activeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeCheckBoxActionPerformed
        this.model.setActive(!this.model.isActive());        
    }//GEN-LAST:event_activeCheckBoxActionPerformed

    private void childCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childCheckBoxActionPerformed
        toggleRoles(Member.Role.Child.ordinal());
    }//GEN-LAST:event_childCheckBoxActionPerformed

    private void parentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentCheckBoxActionPerformed
        toggleRoles(Member.Role.Parent.ordinal());
    }//GEN-LAST:event_parentCheckBoxActionPerformed

    private void coachCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachCheckBoxActionPerformed
        toggleRoles(Member.Role.Coach.ordinal());
    }//GEN-LAST:event_coachCheckBoxActionPerformed

    private void teamSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamSelectActionPerformed
        this.model.setTeam((String) teamSelect.getSelectedItem());
    }//GEN-LAST:event_teamSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activeCheckBox;
    private javax.swing.JButton addTeamButton;
    private javax.swing.JTextField addTeamField;
    private javax.swing.JTextField birthdateField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox childCheckBox;
    private javax.swing.JCheckBox coachCheckBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField givennameField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField joindateField;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JCheckBox parentCheckBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JComboBox teamSelect;
    // End of variables declaration//GEN-END:variables
}
