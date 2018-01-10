package com.ahmadrosid.chatsdk;

import android.view.View;

/**
 * Created by mymacbook on 1/10/18.
 */

class ChatHolderReceive extends ChatHolder {
    public ChatHolderReceive(View view) {
        super(view);
    }

    @Override
    public void bindView(ChatModel chatModel) {
        aq.id(R.id.image_message_profile).image(chatModel.user.userPicture).rounded();
        aq.id(R.id.text_message_body).text(chatModel.message.body);
        aq.id(R.id.text_message_time).text(chatModel.message.date);
    }
}
