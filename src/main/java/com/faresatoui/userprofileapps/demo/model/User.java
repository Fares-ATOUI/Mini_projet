package com.faresatoui.userprofileapps.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Class that represent a User
 */
@Document
public class User {

    @Id
    private String id;
    @NotNull@Size(min = 2, message = "First Name must have at least 2 characters")
    private String firstname;
    @NotNull@Size(min = 2, message = "Last Name must have at least 2 characters")
    private String lastname;
    @NotNull@Size(min = 4, message = "login must have at least 4 characters")
    private String login;
    @NotNull(message = "Birth Date must be filled")
    private LocalDate birthDate;
    @NotNull(message = "Address must be filled")
    private Address address;

    private String bio;

    /**
     * Constructor of a User with all parameters
     * @param firstname of user
     * @param lastname of user
     * @param login of user
     * @param birthdate of user
     * @param address of user
     * @param bio of user
     */
    public User(String firstname, String lastname, String login, LocalDate birthdate, Address address, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.birthDate = birthdate;
        this.address = address;
        this.bio = bio;
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * User formatted
     * @return String user
     */
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", birthdate=" + birthDate +
                ", address=" + address +
                ", bio='" + bio + '\'' +
                '}';
    }
}
