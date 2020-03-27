package com.programmaster.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NotificationManager extends AppCompatActivity {

    public static final int IMPORTANCE_DEFAULT = 1;
    EditText edit;
    private static final String CHANNEL_ID = "123";
    NotificationCompat.Builder notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_manager);

        notification = new NotificationCompat.Builder(this, "default");
        notification.setAutoCancel(false);

    }

    public void createNotificationChannel(View view) {

        Intent intent = new Intent(this, Notification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        edit = (EditText)findViewById(R.id.editText);
        String name = edit.getText().toString();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My notification")
                .setContentText("Hello "+name+" !  welcome to the MAD team")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        //notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, builder.build());



    }

}
