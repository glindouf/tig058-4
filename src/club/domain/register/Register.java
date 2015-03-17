/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.domain.register;

import club.domain.Member;

/**
 *
 * @author phcr
 */
public class Register extends Member {
    
    public Register () {
        super();
    }
     
    private int[] roles;
    private String team;

    public int[] getRoles() {
        return roles;
    }

    public void setRoles(int[] roles) {
        this.roles = roles;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public boolean validate () {
        return (
                (this.getId() != null && !this.getId().equals("")) &&
                (this.getGivenname() != null && !this.getGivenname().equals("")) &&
                (this.getSurname() != null && !this.getSurname().equals("")) &&
                (this.getEmail() != null && !this.getEmail().equals("")) &&
                (this.getGender() > -1) &&
                (this.getBirthdate() > -1) &&
                (this.getJoindate() > -1)                
                );
    }
        
}
