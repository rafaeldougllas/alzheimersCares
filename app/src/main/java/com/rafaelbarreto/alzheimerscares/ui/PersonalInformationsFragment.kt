package com.rafaelbarreto.alzheimerscares.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.ListView
import com.google.gson.Gson
import com.rafaelbarreto.alzheimerscares.model.Link
import com.rafaelbarreto.alzheimerscares.R
import com.rafaelbarreto.alzheimerscares.adapter.PersonalInformationsAdapter
import com.rafaelbarreto.alzheimerscares.adapter.UsefulLinksAdapter
import com.rafaelbarreto.alzheimerscares.model.PersonInfo
import org.jetbrains.anko.appcompat.v7.actionMenuItemView
import org.jetbrains.anko.support.v4.startActivityForResult
import org.jetbrains.anko.toolbar


const val ADD_NEW_PACIENT = 999
//1
class PersonalInformationsFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var adapter: PersonalInformationsAdapter
    //Creating a listview and filling with datas
    lateinit var personList:ArrayList<PersonInfo>
    lateinit var addItemMenu:MenuItem

    //2
    companion object {
        fun newInstance(): PersonalInformationsFragment {
            return PersonalInformationsFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.title = resources.getString(R.string.menu_personal_informations)
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_personal_informations, container, false)

        val person1 = PersonInfo("Rafael Douglas","10024624444",R.drawable.ic_person_white,"","")
        val person2 = PersonInfo("Zezinho Ferraz","09687909878",R.drawable.ic_person_white,"","")
        val person3 = PersonInfo("Lilinha Novaes","10099988876",R.drawable.ic_person_white,"","")

        personList = ArrayList<PersonInfo>()
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)

        listView = view.findViewById<ListView>(R.id.personal_listView)
        adapter  = PersonalInformationsAdapter(inflater.context, personList.toCollection(ArrayList()))
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val personSelected = personList[position]
            Log.d("RAFAAAA",personSelected.name)

        }
        //LongPress Menu #1
        registerForContextMenu(listView)
        return view
    }
    //LongPress Menu #2
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle(R.string.text_menu_ctx_header)
        menu!!.add(0,v!!.id,0,R.string.text_menu_ctx_edit)
        menu!!.add(0,v!!.id,0,R.string.text_menu_ctx_delete)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item!!.title == resources.getString(R.string.text_menu_ctx_edit)){
            Log.d("RAFA","EDIT")
        }else if(item!!.title == resources.getString(R.string.text_menu_ctx_delete)){
            Log.d("RAFA","DELETE")
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        addItemMenu = menu!!.findItem(R.id.action_add)
        addItemMenu.setVisible(true)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            val piAddActivity = Intent(context, PersonalInfoAddActivity::class.java)
            startActivityForResult(piAddActivity, ADD_NEW_PACIENT)
            Log.d("RAFAAA","CLICOU NO ADD")
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ADD_NEW_PACIENT && resultCode == Activity.RESULT_OK){
            if(data != null){
                print("aq")
                Log.d("RAFAA",data?.getStringExtra("NAME"))
            }
        }
    }

}
