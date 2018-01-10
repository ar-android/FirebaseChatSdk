package com.ahmadrosid.chatsdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mymacbook on 1/9/18.
 */

public class ChatUtils {

    public static List<ChatModel> generateFakeListMessage(){
        List<ChatModel> data = new ArrayList<>();
        data.add(generateFakeMessage("myUserId"));
        data.add(generateFakeMessage("amyUserIds", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ."));
        data.add(generateFakeMessage("myUserId"));
        data.add(generateFakeMessage("amyUserIds"));
        data.add(generateFakeMessage("amyUserIds"));
        data.add(generateFakeMessage("amyUserIds"));
        return data;
    }

    public static ChatModel generateFakeMessage(String userId){
        return generateFakeMessage(userId, getBodyMessage());
    }

    public static ChatModel generateFakeMessage(String userId, String body){
        return createMessage(userId, body);
    }

    public static ChatModel createMessage(String userId, String body){
        ChatModel chatModel = new ChatModel();
        ChatModel.Message message = new ChatModel.Message();
        message.body = body;
        message.date = "11:00";
        message.chanelId = "chanelId";
        message.messageId = "messageId";

        ChatModel.User user = new ChatModel.User();
        user.userId = userId;
        user.userName = "rosid";
        user.userPicture = "https://lh4.googleusercontent.com/-g4KhdUVrF5k/AAAAAAAAAAI/AAAAAAAAAAA/AFiYof1obLiDy7E8CXDWfrVgCswIh97Yag/s96-c/photo.jpg";

        chatModel.message = message;
        chatModel.user = user;
        return chatModel;
    }

    private static String getBodyMessage() {
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Rhoncus dolor purus non enim praesent elementum facilisis leo vel. Sed id semper risus in hendrerit gravida rutrum. Mattis enim ut tellus elementum sagittis vitae et leo duis. Enim praesent elementum facilisis leo vel fringilla.";
        Random ran = new Random();
        int randomPosition = ran.nextInt(6) + 25;
        return body.substring(0, randomPosition);
    }


}
