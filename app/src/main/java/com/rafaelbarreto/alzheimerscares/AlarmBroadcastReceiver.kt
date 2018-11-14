package com.rafaelbarreto.alzheimerscares

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.widget.Toast

class AlarmBroadcastReceiver: BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onReceive(context: Context?, intent: Intent?) {
        (context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(
                intent!!.getIntExtra("notificationId", 0),
                Notification.Builder(context).apply {
                    setSmallIcon(android.R.drawable.ic_dialog_info)
                    setContentTitle("AlarmTest")
                    setContentText(intent.getCharSequenceExtra("reminder"))
                    setWhen(System.currentTimeMillis())
                    setPriority(Notification.PRIORITY_DEFAULT)
                    setAutoCancel(true)
                    setDefaults(Notification.DEFAULT_SOUND)
                    setContentIntent(PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))
                }.build()
        )
        Toast.makeText(context,"ALARME",Toast.LENGTH_LONG).show()
        Log.d("RAFA","Tocou o alarme")
    }
}