package club.domain.update;

import club.domain.Member;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author phcr
 */
public class UpdateTabel extends AbstractTableModel {

    private String[] columnNames = {
        "ID",
        "Givenname",
        "Surname",
        "Email",
        "Gender",
        "Birthdate",
        "Joindate",
        "Active",
        "Role(s)",
        "Team"
    };
    
    private final ArrayList<Update> list;
    
    public UpdateTabel(ArrayList<Update> list) {
        this.list = list;
    } 
    
    public String formatRoles(ArrayList<Integer> roles) {
        String fString = "";
        ArrayList<String> strRoles = new ArrayList<>();
        for (Integer i : roles) {
            switch(i) {
                case 0:
                    strRoles.add("Child ");
                    break;
                case 1:
                    strRoles.add("Parent");
                    break;
                case 2:
                    strRoles.add("Coach");
                    break;
            }
        }       
        
        if (strRoles.size() == 1) {
            fString = strRoles.get(0);
        } else if (strRoles.size() > 1) {
            for (String s : strRoles) {
                fString += s + ", ";
            }
            fString = fString.substring(0, fString.length() - 2);
        }
        return fString;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public int getRowCount() {
        return list.size();        
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;        
    }

    @Override
    public Object getValueAt(int row, int col) {
        Update u = list.get(row);
        Object value = "";
        switch (col) {
            case 0:
                value = u.getId();
                break;
            case 1:
                value = u.getGivenname();
                break;
            case 2:
                value = u.getSurname();
                break;
            case 3:
                value = u.getEmail();
                break;
            case 4:
                if (u.getGender()==Member.Gender.Male.ordinal()) {
                    value = "Male";
                } else if (u.getGender()==Member.Gender.Female.ordinal()) {
                    value = "Female";
                }
                break;
            case 5:
                value = new Date(u.getBirthdate());
                break;
            case 6:
                value = new Date(u.getJoindate());
                break;
            case 7:
                value = u.isActive();
                break;
            case 8:                
                value = formatRoles(u.getRoles());
                break;
            case 9:
                value = u.getTeam();
                break;
        }
        return value;
    }   
}
