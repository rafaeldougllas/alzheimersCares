package com.rafaelbarreto.alzheimerscares

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.MenuItem
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_DEMENTIA
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_DIAGNOSTICS
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_RESEARCHES
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_STAGES
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_SYMPTOMS
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_TREATMENT
import com.rafaelbarreto.alzheimerscares.Constants.Companion.CARD_WHAT_IS
import kotlinx.android.synthetic.main.activity_reader.*

class ReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var valueText:Int = 0
        var readerTitle   = ""
        var readerContent = ""
        var readerLink    = ""
        //Recovery the object passed on intent
        if(intent.extras != null){
            valueText  = intent.extras.getInt("TEXT_TO_READ")

            when(valueText){
                Constants.CARD_WHAT_IS -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_SYMPTOMS -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_DIAGNOSTICS -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_TREATMENT -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_STAGES -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_RESEARCHES -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_DEMENTIA -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
            }
        }

        reader_title.text   = readerTitle
        reader_content.text = readerContent
        reader_link.text    = readerLink
    }

    //To make back button work
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        this.finish() /* Close activity */

        return super.onOptionsItemSelected(item)
    }
}
