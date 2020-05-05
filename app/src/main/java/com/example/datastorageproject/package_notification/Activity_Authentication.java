package com.example.datastorageproject.package_notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorageproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class Activity_Authentication extends AppCompatActivity {
    //Notification Channel
    //Notification Builder
    //Notification Manager
    EditText ed1Email,ed2Password;
    Button Login;
    ProgressBar loginProgress;
    private FirebaseAuth firebaseAuth;


    private static final String CHANNEL_ID="Simple_Notification";
    private static final String CHANNEL_NAME="Simple_NotificationName";
    private static final String CHANNEL_DESCRIPTION="Notification_Description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__authentication);

        firebaseAuth=FirebaseAuth.getInstance();
        ed1Email=findViewById(R.id.loginEmail);
        ed2Password=findViewById(R.id.loginPassword);
        Login=findViewById(R.id.loginButton);
        loginProgress=findViewById(R.id.loginprogressbar);
        loginProgress.setVisibility(View.INVISIBLE);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    /*    FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(task.isSuccessful())
                        {
                            String token=task.getResult().getToken();

                        }else {

                        }
                    }
                });*/

    }



    private void createUser(){
        final String email=ed1Email.getText().toString().trim();
        final String password=ed2Password.getText().toString().trim();

        loginProgress.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startNextActivity();
                }else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {

                        userLogin(email,password);
                    }else{
                        loginProgress.setVisibility(View.INVISIBLE);
                        Toast.makeText(Activity_Authentication.this,
                                task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private void userLogin(String email,String password){
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          startNextActivity();

                      }else
                      {
                          loginProgress.setVisibility(View.INVISIBLE);
                          Toast.makeText(Activity_Authentication.this,
                                  task.getException().getMessage(),Toast.LENGTH_LONG).show();
                      }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser()!=null){
         startNextActivity();
        }

    }
    private void startNextActivity(){
        Intent intent=new Intent(Activity_Authentication.this,Activity_SimpleNotification.class);
        startActivity(intent);
    }
    //Function is to display notification
    private void displayNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_sd_card_black_24dp)
                .setContentTitle("Storage Worning ...!")
                .setContentText("Storage full please freeup space")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //To display or to build notification
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());
    }
}
