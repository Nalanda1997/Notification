package com.programmaster.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotificationManager();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            }


        }

        public void openNotificationManager(){
            Intent intent = new Intent(this, NotificationManager.class);
            startActivity(intent);
        }

        public void onDisplay(View view) {
            String message = "Save Your Details !";
            Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();
        }
}
