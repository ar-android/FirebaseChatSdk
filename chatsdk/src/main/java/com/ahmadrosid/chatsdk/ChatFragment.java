package com.ahmadrosid.chatsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aquery.AQuery;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by mymacbook on 1/9/18.
 */

public class ChatFragment extends Fragment {

    private AQuery aq;
    private String chanelId;
    private String uid;

    public static ChatFragment newInstance(String chanelId, String uid) {
        Bundle args = new Bundle();
        args.putString("chanelId", chanelId);
        args.putString("uid", uid);
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aq = new AQuery(view);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        chanelId = getArguments().getString("chanelId");
        uid = getArguments().getString("uid");

        ChatAdapter adapter = new ChatAdapter(uid);
        aq.id(R.id.message_list).adapter(adapter);
        DatabaseReference chanelReference = database.getReference("messages/chanels/" + uid + "/" + chanelId);

        aq.id(R.id.button_chatbox_send).click(__ -> {
            if (isValid()) {
                DatabaseReference push = chanelReference.push();
                ChatModel data = ChatUtils.generateFakeMessage(uid, aq.id(R.id.edittext_chatbox).text());
                push.setValue(data);
                aq.id(R.id.edittext_chatbox).text("");
            }
        });

        chanelReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clearData();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    try {
                        adapter.addData(postSnapshot.getValue(ChatModel.class));
                    } catch (Exception e) {
                        Log.e("Response", "onDataChange: ", e);
                    }
                    int itemCount = adapter.getItemCount() - 1;
                    aq.id(R.id.message_list).recyclerView().smoothScrollToPosition(itemCount);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    boolean isValid() {
        return aq.id(R.id.edittext_chatbox).isValid();
    }

}
