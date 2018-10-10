package com.rafaelbarreto.alzheimerscares

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//1
class TipsFragment : Fragment() {
    //2
    companion object {
        fun newInstance(): TipsFragment{
            return TipsFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        print("aqqqqqqqq")
        Log.d("RAFA","aqqqqqqqqq")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tips, container, false)
    }
}
