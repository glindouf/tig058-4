package club.domain.update;

import club.domain.Member;
import java.util.ArrayList;

/**
 *
 * @author phcr
 */
public class Update extends Member {
    
    private ArrayList<Integer> roles;    
    private String team;        
    
    public Update() {
        super();
        this.roles = new ArrayList<>();
    }

    public ArrayList<Integer> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Integer> roles) {
        this.roles = roles;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }        
    
}
