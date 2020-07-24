package com.galvanize.flightlogapiproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table (name= "users")
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;
    private String password;
    private Boolean isAdmin;
    private Boolean isPiloto;

    public Long getId() { return id;}
    public void setId (Long id) { this.id= id;}

    public String getUserName() { return userName;}
    public void setUserName (String userName) { this.userName= userName;}

    public String getName() { return name;}
    public void setName (String name) { this.name= name; }

    @JsonIgnore
    public String getPassword() { return password;}
    @JsonProperty("password")
    public void setPassword (String password) { this.password= password;}

    public Boolean getIsAdmin() { return isAdmin;}
    public void setIsAdmin (Boolean isAdmin) { this.isAdmin= isAdmin; }

    public Boolean getIsPiloto() { return isPiloto;}
    public void setIsPiloto (Boolean isPiloto) { this.isPiloto= isPiloto; }
}