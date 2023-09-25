package com.kirti.vahanassignment.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.kirti.vahanassignment.views.MainActivity
import com.kirti.vahanassignment.R

class ForegroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

            val channel = NotificationChannel("1",resources.getString(R.string.service_notification), NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, FLAG_IMMUTABLE)


        val notification = NotificationCompat.Builder(this, "1")
            .setContentTitle(resources.getString(R.string.title))
            .setContentText(resources.getString(R.string.content_text))
            .setSmallIcon(R.drawable.ic_vahan)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)

        return START_NOT_STICKY
    }
}