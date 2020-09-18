package com.example.githubapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.listview_item.view.*

class MainListAdapter(val context: Context, val list:ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view : View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        view.listview_item_id.setText(list.get(p0))

        return view
    }

}