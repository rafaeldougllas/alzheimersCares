package com.rafaelbarreto.alzheimerscares

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//1
class PersonalInformationsFragment : Fragment() {
    //2
    companion object {
        fun newInstance(): PersonalInformationsFragment{
            return PersonalInformationsFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_informations, container, false)
    }
}
