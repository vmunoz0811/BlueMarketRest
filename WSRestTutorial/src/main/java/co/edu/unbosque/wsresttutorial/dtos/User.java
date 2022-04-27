package co.edu.unbosque.wsresttutorial.dtos;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String lastname;

    @CsvBindByName
    private String mail;

    @CsvBindByName
    private String username;

    @CsvBindByName
    private String password;

    @CsvBindByName
    private String fcoins;

    @CsvBindByName
    private String profilePhoto;

    public User() {
    }

    public User(String username, String name, String lastname, String mail, String password, String fcoins) {
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.fcoins = fcoins;
        this.profilePhoto = profilePhoto;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFcoins() {
        return fcoins;
    }

    public void setFcoins(String fcoins) {
        this.fcoins = fcoins;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fcoins='" + fcoins + '\'' +
                '}';
    }
}