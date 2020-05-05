package com.example.datastorageproject.package_notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.datastorageproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class Activity_PushNotification extends AppCompatActivity {
    //Notification Channel
    //Notification Builder
    //Notification Manager
    TextView textView;

    private static final String CHANNEL_ID="Simple_Notification";
    private static final String CHANNEL_NAME="Simple_NotificationName";
    private static final String CHANNEL_DESCRIPTION="Notification_Description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__push_notification);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        textView=findViewById(R.id.text);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(task.isSuccessful())
                        {
                            String token=task.getResult().getToken();
                            textView.setText("Token : "+token);
                        }else
                        {
                            textView.setText(task.getException().getMessage());
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
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //To display or to build notification
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());
    }
}
