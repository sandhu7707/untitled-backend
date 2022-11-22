package com.example.portfolio.Model;

import javax.persistence.*;

@Entity
@Table(name="USER_INFO")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne
    private Profile profile;

    //TODO: make this better
    @Column(unique = true)
    private String username;

    private String password;

    public UserInfo(){
    }

    public UserInfo(Long id, String firstName, String lastName, String contactNumber, String emailAddress, Profile profile, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.profile = profile;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
