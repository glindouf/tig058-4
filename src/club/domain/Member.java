package club.domain;

/**
 *
 * @author phcr
 */
public class Member {
    
    public static enum Gender {
        Male,
        Female 
    };
    
    public static enum Role {
        Child,
        Parent,
        Coach
    }
    
    private String id;
    private String givenname;
    private String surname;
    private String email;
    private int gender;
    private long birthdate;
    private long joindate;
    private boolean active = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(long birthdate) {
        this.birthdate = birthdate;
    }

    public long getJoindate() {
        return joindate;
    }

    public void setJoindate(long joindate) {
        this.joindate = joindate;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String toString() {
        return String.format(
                "\nid:\t%s\ngivenname:\t%s\nsurname:\t%s\nemail:\t%s\ngender:\t%d\nbirthdate:\t%d\njoindate:\t%d\nactive:\t%b",
                this.id,
                this.givenname,
                this.surname,
                this.email,
                this.gender,
                this.birthdate,
                this.joindate,
                this.active
        );
    }
    
}
