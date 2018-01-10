package com.ahmadrosid.chatsdk;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aquery.AQuery;

/**
 * Created by mymacbook on 1/9/18.
 */

public abstract class ChatHolder extends RecyclerView.ViewHolder {

    protected AQuery aq;

    public ChatHolder(View itemView) {
        super(itemView);
        aq = new AQuery(itemView);
    }

    public abstract void bindView(ChatModel chatModel);

}
