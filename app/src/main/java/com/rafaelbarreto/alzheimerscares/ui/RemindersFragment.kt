package com.rafaelbarreto.alzheimerscares.ui

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.fragment_reminders.*
import com.rafaelbarreto.alzheimerscares.AlarmBroadcastReceiver
import com.rafaelbarreto.alzheimerscares.R
import java.util.*



//1
class RemindersFragment : Fragment() {
    var notificationId = 0

    //2
    companion object {
        fun newInstance(): RemindersFragment {
            return RemindersFragment()
        }
    }

    //3
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.title = resources.getString(R.string.menu_reminders)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reminders, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        time_picker.setIs24HourView(true)

        val alarmManager = activity!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        button_set.setOnClickListener {
            Log.d("Rafae2","asdasdasdas asdasdasd")
            if (edit_text.text.isBlank()) {
                Toast.makeText(context, "Title is Required!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, time_picker.hour)
                        set(Calendar.MINUTE, time_picker.minute)
                        set(Calendar.SECOND, 0)
                    }.timeInMillis,
                    PendingIntent.getBroadcast(
                            context,
                            0,
                            Intent(context, AlarmBroadcastReceiver::class.java).apply {
                                putExtra("notificationId", ++notificationId)
                                putExtra("reminder", edit_text.text)
                            },
                            PendingIntent.FLAG_CANCEL_CURRENT
                    )
            )
            Toast.makeText(context, "SET!! ${edit_text.text}", Toast.LENGTH_SHORT).show()
            reset()
        }

        button_cancel.setOnClickListener {
            alarmManager.cancel(
                    PendingIntent.getBroadcast(
                            context, 0, Intent(context, AlarmBroadcastReceiver::class.java), 0))
            Toast.makeText(context, "CANCEL!!", Toast.LENGTH_SHORT).show()
        }
        super.onStart()
    }

    fun onTouchEvent(event: MotionEvent?): Boolean {
        (activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(layout_reminder.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        layout_reminder.requestFocus()
        return activity!!.onTouchEvent(event)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResume() {
        super.onResume()
        reset()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun reset() {
        time_picker.apply {
            val now = Calendar.getInstance()
            hour = now.get(Calendar.HOUR_OF_DAY)
            minute = now.get(Calendar.MINUTE)
        }
        edit_text.setText("")
    }
}
