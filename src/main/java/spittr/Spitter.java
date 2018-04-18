package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    @NotNull
    @Size(min=5, max=16)
    private String username;
    @NotNull
    @Size(min=5, max=25)
    private String password;
    @NotNull
    @Size(min=2, max=30)
    private String firstName;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    private Long id;

    public Spitter(){
        this(null, null, null, null);
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + username + " " + password;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Spitter))return false;
        Spitter spitter = (Spitter)o;
        return firstName.equals(spitter.firstName) && lastName.equals(spitter.lastName)
                && username.equals(spitter.username) && password.equals(spitter.password);
    }
}
