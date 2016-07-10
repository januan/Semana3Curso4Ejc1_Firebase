package com.javiernunez.puppies.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.javiernunez.puppies.MainActivity;
import com.javiernunez.puppies.R;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    public static final String TAG ="FIREBASE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        //Log.d(TAG, "To: " + remoteMessage.getTo());
        Log.d(TAG, "Title: " + remoteMessage.getNotification().getTitle());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.footprint)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;

        NotificationManager notificacionManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificacionManager.notify(0, notificacion.build());

    }
}
