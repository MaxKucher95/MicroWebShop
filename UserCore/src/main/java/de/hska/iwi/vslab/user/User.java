package de.hska.iwi.vslab.user;

@javax.persistence.Entity
public class User 
{
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name="USER_ID")
    private Long id;

    @javax.persistence.Column(name="USER_NAME")
    private String name;

    @javax.persistence.Column(name="USER_PWD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}