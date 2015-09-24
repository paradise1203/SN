package com.aidar.data;

import java.util.List;

public interface MessageDAO {

    public List<Message> getMessages(Integer sId, Integer rId);

    public void addMessage(Integer sId, Integer rId, String message);

    public List<Message> getNewMessages(Integer sId, Integer rId);

}
