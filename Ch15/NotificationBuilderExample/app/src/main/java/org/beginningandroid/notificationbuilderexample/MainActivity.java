package org.beginningandroid.notificationbuilderexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID=12345;
    private static final String MYCHANNEL = "";
    private int notifyCount = 0;
    private NotificationManager myNotifyMgr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNotifyMgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O &&
                myNotifyMgr.getNotificationChannel(MYCHANNEL)==null)
                    { myNotifyMgr.createNotificationChannel(new NotificationChannel(MYCHANNEL,
                            "My Channel", NotificationManager.IMPORTANCE_DEFAULT));
                    }
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.notify:
                raiseNotification(view);
                break;
            case R.id.clearNotify:
                dismissNotification(view);
                break;
        }
    }

    public void raiseNotification(View view) {
        Intent myIntent = new Intent(this, NotificationFollowon.class);
        PendingIntent myPendingIntent = PendingIntent.getActivity(MainActivity.this, 1, myIntent, 0);

        NotificationCompat.Builder myNotifyBuilder = new NotificationCompat.Builder(MainActivity.this, MYCHANNEL);

        myNotifyBuilder.setAutoCancel(false);
        myNotifyBuilder.setTicker("Here is your ticker text");
        myNotifyBuilder.setNumber(++notifyCount);
        myNotifyBuilder.setContentTitle("An Android Notification");
        myNotifyBuilder.setContentText("Notice This!");
        myNotifyBuilder.setSmallIcon(R.drawable.wavinghand);
        myNotifyBuilder.setContentIntent(myPendingIntent);
        myNotifyBuilder.build();

        Notification myNotification = myNotifyBuilder.getNotification();
        myNotifyMgr.notify(NOTIFICATION_ID, myNotification);
    }

    public void dismissNotification(View view) {
        myNotifyMgr.cancel(NOTIFICATION_ID);
    }

}