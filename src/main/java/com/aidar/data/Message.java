package com.aidar.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_message")
public class Message {

    @Id
    @Column
    private int id;

    @Column(name = "sender_id")
    private int senderId;

    @Column(name = "recipient_id")
    private int recipientId;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message() {
    }

    public Message(int senderId, int recipientId, String message, Date date) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
