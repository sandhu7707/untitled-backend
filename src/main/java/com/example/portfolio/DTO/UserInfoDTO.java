package com.example.portfolio.DTO;

public class UserInfoDTO {

    private Long id;

    private ProfileDTO profile;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private String emailAddress;

    //TODO: find a better way,
    // even this feels like it should be a separate entity
    private String username;

    private String password;

    public UserInfoDTO(Long id, ProfileDTO profileDTO, String firstName, String lastName, String contactNumber, String emailAddress) {
        this.id = id;
        this.profile = profileDTO;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
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
}
