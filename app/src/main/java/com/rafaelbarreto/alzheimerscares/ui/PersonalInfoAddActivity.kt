package com.rafaelbarreto.alzheimerscares.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.Log
import android.view.MenuItem
import com.rafaelbarreto.alzheimerscares.Constants
import com.rafaelbarreto.alzheimerscares.R
import kotlinx.android.synthetic.main.activity_personal_info_add.*
import kotlinx.android.synthetic.main.activity_reader.*

class PersonalInfoAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info_add)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_add_new_pacient.setOnClickListener{
            val backIntent = Intent()
            backIntent.putExtra("NAME",name_input.text.toString())
            setResult(Activity.RESULT_OK,backIntent)
            finish()
        }
        //roundImage()
    }

    fun roundImage(){
        //val img = BitmapFactory.decodeResource(resources,R.drawable.ic_person_white)
        //val round = RoundedBitmapDrawableFactory.create(resources,img)

        //round.isCircular = true
        //pacient_image.setImageDrawable(round)
    }

    //To make back button work
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        this.finish() /* Close activity */

        return super.onOptionsItemSelected(item)
    }
}
