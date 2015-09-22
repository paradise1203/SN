package com.aidar.data;

import javax.persistence.*;

@Entity
@Table(name = "user_friends")
public class Friends {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_id")
    private int firstId;

    @Column(name = "second_id")
    private int secondId;

    public Friends() {
    }

    public Friends(int firstId, int secondId) {
        this.firstId = firstId;
        this.secondId = secondId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

}
