package com.example.smyttendemo.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.smyttendemo.R
import com.example.smyttendemo.model.ContentItem
import com.example.smyttendemo.model.ProductItem
import com.example.smyttendemo.ui.activityA.ActivityA
import com.example.smyttendemo.ui.activityB.ActivityB
import com.example.smyttendemo.ui.activityC.ActivityC
import com.example.smyttendemo.ui.activityD.ActivityD
import com.example.smyttendemo.ui.activityE.ActivityE
import com.example.smyttendemo.ui.activityF.ActivityF
import com.squareup.picasso.Picasso

class HomeAdapter(private val context: Context, private val contentList: List<ContentItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_PRODUCT = 1
        const val VIEW_TYPE_BUTTON = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_PRODUCT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view)
            }
            VIEW_TYPE_BUTTON -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_button, parent, false)
                ButtonViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                val productItem = contentList[position].data[0]
                Picasso.get().load(productItem.image).into(holder.productImage)
                holder.brandAndProductName.text = "${productItem.brand} ${productItem.name}"
                holder.addToCartButton.setOnClickListener {
                    holder.addToCartButton.text = "In Cart"
                    holder.addToCartButton.isEnabled = false
                }
            }
            is ButtonViewHolder -> {
                val buttonItem =  contentList[position].data[0]

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
        }
    }

    override fun getItemCount(): Int = contentList.size

    override fun getItemViewType(position: Int): Int {
        return when (contentList[position].type) {
            "PRODUCT" -> VIEW_TYPE_PRODUCT
            "BUTTON" -> VIEW_TYPE_BUTTON
            else -> throw IllegalArgumentException("Invalid content type")
        }
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val brandAndProductName: TextView = itemView.findViewById(R.id.brandAndProductName)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }

    class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView as Button
    }
}
