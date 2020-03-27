package com.example.lab7;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_1_ID = "channel11";
    public static final String CHANNEL_2_ID = "channel12";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationsChannel();
    }

    private void createNotificationsChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel11 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel11.setDescription("This is Channel 1");

            NotificationChannel channel12 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel12.setDescription("This is Channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel11);
            manager.createNotificationChannel(channel12);
        }
    }
}
