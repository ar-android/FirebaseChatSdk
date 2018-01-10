package com.ahmadrosid.chatsdk;

/**
 * Created by mymacbook on 1/9/18.
 */

public class ChatModel {
    public User user;
    public Message message;

    public static class User {
        public String userName;
        public String userId;
        public String userPicture;
    }

    public static class Message {
        public String date;
        public String body;
        public String messageId;
        public String chanelId;
    }
}
