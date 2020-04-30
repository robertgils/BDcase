package BDExchange.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id @GeneratedValue
    private int id;

    private String emailaddress;
    private String password;

    private User() { }
    public User(String emailaddress, String password) {
        this.emailaddress = emailaddress;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username = " + emailaddress +
                ", password =" + password;
    }
}
