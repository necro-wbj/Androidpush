package org.hopto.wbj.androidpush;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    final String TAG = "necro-wbj";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
            Log.d(TAG, "From: " + remoteMessage.getFrom());

            // Check if message contains a data payload.
            if (remoteMessage.getData().size() > 0) {
                Log.d(TAG, "data訊息(payload): " + remoteMessage.getData());

                //TODO: 處理Data訊息
            }

            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Notification提示訊息的內容: " + remoteMessage.getNotification().getBody());
                //TODO: 處理提示訊息
            }


            //TODO: 發提示訊息到主要介面中
    }
}
