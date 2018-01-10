package com.ahmadrosid.chatsdk;

import android.view.View;

/**
 * Created by mymacbook on 1/10/18.
 */

class ChatHolderSent extends ChatHolder{

    public ChatHolderSent(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(ChatModel chatModel) {
        aq.id(R.id.text_message_body).text(chatModel.message.body);
        aq.id(R.id.text_message_time).text(chatModel.message.date);
    }
}
