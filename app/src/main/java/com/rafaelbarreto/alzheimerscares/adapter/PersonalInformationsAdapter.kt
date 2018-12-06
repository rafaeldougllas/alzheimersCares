package com.rafaelbarreto.alzheimerscares.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.rafaelbarreto.alzheimerscares.model.Link
import com.rafaelbarreto.alzheimerscares.R
import com.rafaelbarreto.alzheimerscares.model.PersonInfo

class PersonalInformationsAdapter(private val context: Context?,
                         private val dataSource: ArrayList<PersonInfo>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.personal_info_row, parent, false)

            // 3
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.person_img) as ImageView
            holder.nameTextView = view.findViewById(R.id.person_name) as TextView
            holder.idTextView = view.findViewById(R.id.person_id) as TextView

            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
        val nameTextView = holder.nameTextView
        val idTextView = holder.idTextView
        val thumbnailImageView = holder.thumbnailImageView

        val person = getItem(position) as PersonInfo

        nameTextView.text = person.name
        idTextView.text = person.id
        thumbnailImageView.setImageResource(R.drawable.ic_person_white)

        return view
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var idTextView: TextView
        lateinit var thumbnailImageView: ImageView
    }


}