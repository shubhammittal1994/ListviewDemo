


package com.sampleapp.module.listview.adapter

import com.sampleapp.R

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sampleapp.data.response.Row
import com.squareup.picasso.Picasso

class ListAdapterCustom(private val context: Context,
                        private val dataList: List<Row>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var txtTitle: TextView? = null
        var txtRating: TextView? = null
        var imageview:ImageView?=null

        init {
            this.txtTitle = row?.findViewById<TextView>(R.id.title)
            this.txtRating = row?.findViewById<TextView>(R.id.rating)
            this.imageview=row?.findViewById(R.id.thumbnail)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.listview, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        var userDto = dataList[position]
        if (userDto.title!=null) {
            viewHolder.txtTitle?.text = userDto.title
            viewHolder.txtRating?.text = userDto.description


            if (userDto.imageHref!=null)
            Picasso.get()
                    .load(userDto.imageHref).error(R.drawable.noimage)
                    .into(viewHolder.imageview)
            else
            viewHolder.imageview!!.setImageResource(R.drawable.noimage)

        }
        return view as View
    }

    override fun getItem(i: Int): Row {
        return dataList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return dataList.size
    }
}