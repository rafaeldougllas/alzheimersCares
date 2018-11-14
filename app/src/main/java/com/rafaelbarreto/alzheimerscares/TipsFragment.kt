package com.rafaelbarreto.alzheimerscares

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import kotlinx.android.synthetic.main.fragment_tips.*


//1
class TipsFragment : Fragment() {
    val pdf_url:String = "http://bvsms.saude.gov.br/bvs/publicacoes/guia_pratico_cuidador.pdf"
    //2
    companion object {
        fun newInstance(): TipsFragment{
            return TipsFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tips, container, false)
    }

    override fun onStart() {
        webView_tips.settings.javaScriptEnabled = true
        webView_tips.loadUrl(pdf_url)
        super.onStart()
    }
}
