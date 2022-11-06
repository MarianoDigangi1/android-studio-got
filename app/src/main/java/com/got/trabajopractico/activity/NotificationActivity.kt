package com.got.trabajopractico.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.got.trabajopractico.R

class NotificationActivity : AppCompatActivity() {

    private val channelId = "channelID"
    private val channelName = "channelName"
    private val notificationId = 0

    companion object{
        const val INTENT_REQUEST = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        createNotificationChannel();

        val intent = Intent(this, LoginActivity::class.java)

        val pendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(INTENT_REQUEST, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, channelId).also {
            it.setContentTitle("App Game of thrones")
            it.setContentText("Ingrese a la App!")
            it.setSmallIcon(R.drawable.ic_notification)
            it.setPriority(NotificationCompat.PRIORITY_MAX)
            it.setContentIntent(pendingIntent)
            it.setAutoCancel(true)
        }.build()

        val notificationManager = NotificationManagerCompat.from(this)

        notificationManager.notify(notificationId, notification)
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importancia = NotificationManager.IMPORTANCE_HIGH;

            val channel = NotificationChannel(channelId, channelName, importancia).apply {
                //LightColor = Color.RED;
                enableLights(true);
            }

            val manager =  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
            manager.createNotificationChannel(channel);
        }
    }
}