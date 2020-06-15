package de.hska.iwi.vslab.user;

@javax.persistence.Entity
public class User 
{
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name="USER_ID")
    private Long id;

    @javax.persistence.Column(name="USER_FIRSTNAME")
    private String firstName;

    @javax.persistence.Column(name="USER_LASTNAME")
    private String lastName;

    @javax.persistence.Column(name="USER_USERNAME")
    private String userName;

    @javax.persistence.Column(name="USER_PWD")
    private String password;

    @javax.persistence.Column(name="USER_ROLE")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}