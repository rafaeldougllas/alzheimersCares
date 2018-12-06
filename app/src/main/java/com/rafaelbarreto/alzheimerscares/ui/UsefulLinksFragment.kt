package com.rafaelbarreto.alzheimerscares.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.gson.Gson
import com.rafaelbarreto.alzheimerscares.model.Link
import com.rafaelbarreto.alzheimerscares.R
import com.rafaelbarreto.alzheimerscares.adapter.UsefulLinksAdapter

//1
class UsefulLinksFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var adapter: UsefulLinksAdapter

    //2
    companion object {
        fun newInstance(): UsefulLinksFragment {
            return UsefulLinksFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        activity?.title = resources.getString(R.string.menu_useful_links)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_useful_links, container, false)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = view.findViewById<ListView>(R.id.site_listView)
        adapter = UsefulLinksAdapter(inflater.context, schoolList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val siteSelected = schoolList[position]

            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(siteSelected.link)))
        }
        return view
    }

    fun getDatas(): ArrayList<Link> {
        val jsonStr = getJsonSt()
        val linksListFromServ = Gson().fromJson(jsonStr, Array<Link>::class.java)
        val LinksList = linksListFromServ.toCollection(ArrayList())

        return LinksList
    }

    fun getJsonSt(): String {
        val js = """[
          {
            "name": "ABRAZ",
            "link": "http://www.abraz.org.br/",
            "image_id":0
          },
          {
            "name": "ALZ",
            "link": "https://www.alz.org/br/",
            "image_id":1
          },
          {
            "name": "ALZHEIMER PORTUGAL",
            "link": "http://www.alzheimerportugal.org",
            "image_id":2
          },
          {
            "name": "ALZHEIMER MED",
            "link": "http://www.alzheimermed.com.br/",
            "image_id":3
          },
          {
            "name": "ALZHEIMERS NET",
            "link": "http://www.alzheimers.net",
            "image_id":4
          },
          {
            "name": "GAAIN - The Global Alzheimer's Association Interactive Network",
            "link": "http://www.gaain.org/",
            "image_id":5
          },
          {
            "name": "PSYCHIATRY - AMERICAN PSYCHIATRIC ASSOCIATION",
            "link": "https://www.psychiatry.org/patients-families/alzheimers",
            "image_id":6
          },
          {
            "name": "MINHAVIDA",
            "link": "https://www.minhavida.com.br/",
            "image_id":7
          }]
          """
        return js

    }
}
