package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivities(this,0, new Intent[]{intent},0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is content file")
                        .setContentText("this is content text")
                        .setWhen(System.currentTimeMillis())
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("iiiiiiiijjjjjjjjjjjjjjjjjjjjjkhhhhhh" +
////                                "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture
                                (BitmapFactory.decodeResource(getResources(),R.drawable.pic)))
//                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
