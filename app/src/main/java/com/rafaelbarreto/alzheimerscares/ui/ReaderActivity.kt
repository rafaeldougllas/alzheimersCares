package com.rafaelbarreto.alzheimerscares.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.rafaelbarreto.alzheimerscares.Constants
import com.rafaelbarreto.alzheimerscares.R
import kotlinx.android.synthetic.main.activity_reader.*
import kotlinx.android.synthetic.main.reader_footer.view.*
import kotlinx.android.synthetic.main.reader_header.view.*

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
            valueText  = intent.extras.getInt(Constants.CARD_NUMBER_CLICKED)

            when(valueText){
                Constants.CARD_WHAT_IS -> {
                    readerTitle   = resources.getString(R.string.menu_about_what_is)
                    readerContent = resources.getString(R.string.text_what_is)
                    readerLink    = resources.getString(R.string.text_what_is_link)
                }
                Constants.CARD_SYMPTOMS -> {
                    readerTitle   = resources.getString(R.string.menu_about_symptoms)
                    readerContent = resources.getString(R.string.text_symptoms)
                    readerLink    = resources.getString(R.string.text_symptoms_link)
                }
                Constants.CARD_DIAGNOSTICS -> {
                    readerTitle   = resources.getString(R.string.menu_about_diagnostic)
                    readerContent = resources.getString(R.string.text_diagnosis)
                    readerLink    = resources.getString(R.string.text_diagnosis_link)
                }
                Constants.CARD_TREATMENT -> {
                    readerTitle   = resources.getString(R.string.menu_about_treatment)
                    readerContent = resources.getString(R.string.text_treatment)
                    readerLink    = resources.getString(R.string.text_treatment_link)
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

        //reader_title.text   = readerTitle
        //reader_content.text = readerContent
        val texts = readerContent.split("#*")
        val listTexts = arrayOfNulls<String>(texts.size)
        for (i in 0 until texts.size){
            listTexts[i] = texts[i]
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listTexts)
        reader_list_content.adapter = adapter
        val headerView = layoutInflater.inflate(R.layout.reader_header, null)
        headerView.reader_title.text = readerTitle
        reader_list_content.addHeaderView(headerView)

        val footerView = layoutInflater.inflate(R.layout.reader_footer, null)
        footerView.reader_link.text = readerLink
        reader_list_content.addFooterView(footerView)

        //reader_link.text    = readerLink
    }

    //To make back button work
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        this.finish() /* Close activity */

        return super.onOptionsItemSelected(item)
    }
}
