package com.example.smyttendemo.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.smyttendemo.R
import com.example.smyttendemo.model.ProductItem
import com.example.smyttendemo.ui.activityA.ActivityA
import com.example.smyttendemo.ui.activityB.ActivityB
import com.example.smyttendemo.ui.activityC.ActivityC
import com.example.smyttendemo.ui.activityD.ActivityD
import com.example.smyttendemo.ui.activityE.ActivityE
import com.example.smyttendemo.ui.activityF.ActivityF

class ButtonAdapter(private val context: Context, private val buttonList: List<ProductItem>) :
    RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_button, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val buttonItem = buttonList[position]

        holder.button.text = buttonItem.name

        holder.button.setOnClickListener {
            when (buttonItem.id) {
                1 -> {
                    val intent = Intent(context, ActivityA::class.java)
                    context.startActivity(intent)
                }
                2 -> {
                    val intent = Intent(context, ActivityB::class.java)
                    context.startActivity(intent)
                }
                3 -> {
                    val intent = Intent(context, ActivityC::class.java)
                    context.startActivity(intent)
                }
                4 -> {
                    val intent = Intent(context, ActivityD::class.java)
                    context.startActivity(intent)
                }
                5 -> {
                    val intent = Intent(context, ActivityE::class.java)
                    context.startActivity(intent)
                }
                6 -> {
                    val intent = Intent(context, ActivityF::class.java)
                    context.startActivity(intent)
                }
                else -> {
                    Toast.makeText(context, "No Activity Found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return buttonList.size
    }

    class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView as Button
    }
}