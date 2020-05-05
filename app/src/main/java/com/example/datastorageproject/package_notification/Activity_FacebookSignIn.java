package com.example.datastorageproject.package_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.datastorageproject.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Activity_FacebookSignIn extends AppCompatActivity {
    private static final String EMAIL = "email";
    CallbackManager callbackManager = CallbackManager.Factory.create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__facebook_sign_in);



        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        CallbackManager callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent=new Intent(Activity_FacebookSignIn.this,Activity_SimpleNotification.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                Toast.makeText(Activity_FacebookSignIn.this, "Cancled.....", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(Activity_FacebookSignIn.this, "Error.....", Toast.LENGTH_SHORT).show();
                // App code
            }
        });


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Intent intent=new Intent(Activity_FacebookSignIn.this,Activity_GoogleSignIn.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(Activity_FacebookSignIn.this, "Canceled 2.....", Toast.LENGTH_SHORT).show();
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Toast.makeText(Activity_FacebookSignIn.this, "Error 2.....", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(null, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(null, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(null, "printHashKey()", e);
        }
    }*/
}
