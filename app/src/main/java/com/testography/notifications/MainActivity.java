package com.testography.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int NOTIFICATION_ID = 225;

    private EditText mTitle;
    private EditText mMessage;
    private CheckBox mAddActionButton;

    private NotificationCompat.Builder mNotifBuilder;
    private NotificationManager mNotifMngr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (EditText) findViewById(R.id.etTitle);
        mMessage = (EditText) findViewById(R.id.etMessage);
        mAddActionButton = (CheckBox) findViewById(R.id.dbAddActionButton);
        mNotifMngr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onCreateNotification(View view) {
        mNotifBuilder = new NotificationCompat.Builder(this);
        mNotifBuilder.setContentTitle(mTitle.getText().toString());
        mNotifBuilder.setContentText(mMessage.getText().toString());
        if (mAddActionButton.isChecked()) {
            mNotifBuilder.addAction(R.drawable.abc_ic_menu_share_mtrl_alpha,
                    "Share", null);
        }
        mNotifBuilder.setSmallIcon(android.R.drawable.ic_notification_clear_all);
        Notification newNotif = mNotifBuilder.build();
        mNotifMngr.notify(NOTIFICATION_ID, newNotif);
    }
}
