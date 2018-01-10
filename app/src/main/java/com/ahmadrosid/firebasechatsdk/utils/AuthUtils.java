package com.ahmadrosid.firebasechatsdk.utils;

import android.app.Activity;
import android.content.Intent;

import com.ahmadrosid.firebasechatsdk.R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * Created by mymacbook on 1/9/18.
 */

public class AuthUtils {

    public void setupGoogleLogin(Activity activity){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

}
