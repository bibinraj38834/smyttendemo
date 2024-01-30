package com.example.smyttendemo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smyttendemo.R
import com.example.smyttendemo.model.ProductItem
import com.squareup.picasso.Picasso

class ProductAdapter(private val context: Context, private val productList: List<ProductItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = productList[position]

//        holder.productImage.setImageResource(productItem.image)
        holder.brandAndProductName.text = "${productItem.brand} ${productItem.name}"

        // Set onClickListener for "Add to Cart" button
        holder.addToCartButton.setOnClickListener {
            holder.addToCartButton.text = "In Cart"
            holder.addToCartButton.isEnabled = false
        }

        Picasso.get().load(productItem.image).into(holder.productImage)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val brandAndProductName: TextView = itemView.findViewById(R.id.brandAndProductName)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }
}
