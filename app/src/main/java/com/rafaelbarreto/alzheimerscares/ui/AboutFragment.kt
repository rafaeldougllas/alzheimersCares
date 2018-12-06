package com.rafaelbarreto.alzheimerscares.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rafaelbarreto.alzheimerscares.Constants
import com.rafaelbarreto.alzheimerscares.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

//1
class AboutFragment : Fragment() {
    //2
    companion object {
        fun newInstance(): AboutFragment {
            return AboutFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        activity?.title = resources.getString(R.string.menu_about)

        // Inflate the layout for this fragment
        val aboutView = inflater.inflate(R.layout.fragment_about, container, false)

        aboutView.card_what_is.setOnClickListener{
            showReaderActivity(aboutView.card_what_is,inflater.context)
        }
        aboutView.card_symptoms.setOnClickListener{
            showReaderActivity(aboutView.card_symptoms,inflater.context)
        }
        aboutView.card_diagnostic.setOnClickListener{
            showReaderActivity(aboutView.card_diagnostic,inflater.context)
        }
        aboutView.card_treatment.setOnClickListener{
            showReaderActivity(aboutView.card_treatment,inflater.context)
        }

        return aboutView
    }

    fun showReaderActivity(item_menu:CardView,context: Context){
        val readerActivity = Intent(context, ReaderActivity::class.java)
        var textToRead           = 0
        when (item_menu){
            card_what_is -> textToRead = Constants.CARD_WHAT_IS
            card_symptoms -> textToRead = Constants.CARD_SYMPTOMS
            card_diagnostic -> textToRead = Constants.CARD_DIAGNOSTICS
            card_treatment -> textToRead = Constants.CARD_TREATMENT
            card_stages -> textToRead = Constants.CARD_STAGES
            card_researches -> textToRead = Constants.CARD_RESEARCHES
            card_dementia -> textToRead = Constants.CARD_DEMENTIA
            else -> textToRead = 0
        }
        readerActivity.putExtra(Constants.CARD_NUMBER_CLICKED,textToRead)
        startActivity(readerActivity)
    }
}
