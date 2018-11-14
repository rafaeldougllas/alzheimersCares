package com.rafaelbarreto.alzheimerscares

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UsefulLinksAdapter(private val context: Context?,
                         private val dataSource: ArrayList<Link>) : BaseAdapter() {

    private val imagesIds = arrayOf(R.drawable.logo_abraz,R.drawable.logo_alz_org,R.drawable.logo_alzheimer_portugal,R.drawable.logo_alzheimermed,R.drawable.logo_alzheimers_net,R.drawable.logo_gaain_org,R.drawable.logo_psychiatry_org,R.drawable.logo_minhavida)


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
            view = inflater.inflate(R.layout.useful_link_row, parent, false)

            // 3
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.site_img) as ImageView
            holder.nameTextView = view.findViewById(R.id.site_name) as TextView
            holder.linkTextView = view.findViewById(R.id.site_link) as TextView

            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
        val nameTextView = holder.nameTextView
        val linkTextView = holder.linkTextView
        val thumbnailImageView = holder.thumbnailImageView

        val siteLink = getItem(position) as Link

        nameTextView.text = siteLink.name
        linkTextView.text = siteLink.link
        thumbnailImageView.setImageResource(imagesIds[siteLink.image_id])

        //Muda as fontes
//        val titleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
//        nameTextView.typeface = titleTypeFace
//        val subtitleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
//        addressTextView.typeface = subtitleTypeFace

        return view
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var linkTextView: TextView
        lateinit var thumbnailImageView: ImageView
    }


}