package com.ahmadrosid.chatsdk;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mymacbook on 1/9/18.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatHolder> {

    private List<ChatModel> data;
    private int SENT_LAYOUT = 100;
    private int RECEIVE_LAYOUT = 101;
    private String uid;

    public ChatAdapter(String uid) {
        this.uid = uid;
        this.data = new ArrayList<>();
    }

    public void setData(List<ChatModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(ChatModel model) {
        data.add(model);
        notifyDataSetChanged();
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == SENT_LAYOUT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
            return new ChatHolderSent(view);
        } else if (viewType == RECEIVE_LAYOUT){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
            return new ChatHolderReceive(view);
        }else {
            return new ChatHolder(new View(parent.getContext())) {
                @Override
                public void bindView(ChatModel chatModel) {

                }
            };
        }
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        holder.bindView(data.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatModel chatModel = data.get(position);
        String userId = chatModel.user.userId;
        if (TextUtils.equals(userId, uid)) {
            return SENT_LAYOUT;
        } else {
            return RECEIVE_LAYOUT;
        }
    }

    public void clearData() {
        data.clear();
    }
}
