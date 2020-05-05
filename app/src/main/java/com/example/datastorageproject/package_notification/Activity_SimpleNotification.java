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
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorageproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class Activity_SimpleNotification extends AppCompatActivity {
    //Notification Channel
    //Notification Builder
    //Notification Manager
   public static final String NODE_USER="user";
    FirebaseAuth firebaseAuth;
    TextView textView;
    Button buttonNotification;
    public static final String CHANNEL_ID="Simple_Notification";
    private static final String CHANNEL_NAME="Simple_NotificationName";
    private static final String CHANNEL_DESCRIPTION="Notification_Description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__simple_notification);
       //To get token
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(task.isSuccessful())
                        {
                            String token=task.getResult().getToken();
                            saveToken(token);

                        }
                    }
                });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        textView=findViewById(R.id.text);
        buttonNotification=findViewById(R.id.buttonNotify);

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               displayNotification();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser()==null){
            Intent intent=new Intent(Activity_SimpleNotification.this,Activity_Authentication.class);
            startActivity(intent);
        }

    }

    private void saveToken(String Token)
    {

        firebaseAuth=FirebaseAuth.getInstance();
        String email=firebaseAuth.getCurrentUser().getEmail();
        User user=new User(email,Token);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(NODE_USER);
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Activity_SimpleNotification.this,
                                    "Token Saved",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    //Function is to display notification
    private void displayNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_sd_card_black_24dp)
                .setContentTitle("Storage Worning ...!")
                .setContentText("Storage full please freeup space")
                .setPriority(NotificationCompat.DEFAULT_SOUND);

        //To display or to build notification
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());
    }
}
