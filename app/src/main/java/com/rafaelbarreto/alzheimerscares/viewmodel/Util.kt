package com.rafaelbarreto.alzheimerscares.viewmodel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import com.rafaelbarreto.alzheimerscares.R
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.backgroundColor

class Util {
    companion object {
        fun showToast(context: Context){
            Toast.makeText(context, "PEGOU", Toast.LENGTH_LONG).show()
        }
    }
}