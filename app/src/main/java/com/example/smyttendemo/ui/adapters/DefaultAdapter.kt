package com.example.smyttendemo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smyttendemo.R

class DefaultAdapter : RecyclerView.Adapter<DefaultAdapter.DefaultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_default, parent, false)
        return DefaultViewHolder(view)
    }

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
        // You can customize the default item as needed
    }

    override fun getItemCount(): Int {
        // Return the number of items in the default adapter
        return 1
    }

    class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}