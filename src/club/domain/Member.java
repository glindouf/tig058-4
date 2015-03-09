
package club.domain;

import java.util.Calendar;

/**
 *
 * @author phcr
 */
public class Member {
    
    public static enum Gender {
        Male,
        Female 
    };
    
    private String id;
    private String givenname;
    private String surname;
    private String email;
    private Gender gender;
    private Calendar birthdate;
    private Calendar joindate;
    private boolean active;    
    
}
