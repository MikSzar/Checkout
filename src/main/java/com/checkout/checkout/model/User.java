package com.checkout.checkout.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;

    private String firstname;
    private String lastname;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Item> items;

    public User() {

    }

    public User(Integer userId, String firstname, String lastname) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId().equals(user.getUserId()) && getFirstname().equals(user.getFirstname()) && getLastname().equals(user.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstname(), getLastname());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
