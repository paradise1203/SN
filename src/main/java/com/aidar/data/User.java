package com.aidar.data;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "city")
    private String city;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    public User() {
    }

    public User(int id, String firstName, String lastName, String sex, String city, String mobilePhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.city = city;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public int hashCode() {
        return id + firstName.length() + lastName.length() + sex.length();
    }

    @Override
    public boolean equals(Object obj) {
        User user;
        if (!(obj instanceof User))
            return false;
        else
            user = (User) obj;
        return id == user.getId() && firstName.equals(user.getFirstName()) &&
                lastName.equals(user.getLastName()) && sex.equals(user.getSex());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

}
