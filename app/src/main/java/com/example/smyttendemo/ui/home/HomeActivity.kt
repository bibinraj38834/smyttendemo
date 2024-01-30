package com.example.smyttendemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smyttendemo.R
import com.example.smyttendemo.model.DataModel
import com.example.smyttendemo.model.ProductItem
import com.example.smyttendemo.ui.adapters.ButtonAdapter
import com.example.smyttendemo.ui.adapters.DefaultAdapter
import com.example.smyttendemo.ui.adapters.HomeAdapter
import com.example.smyttendemo.ui.adapters.ProductAdapter
import com.example.smyttendemo.utils.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var verticalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        verticalRecyclerView = findViewById(R.id.verticalRecyclerView)
        verticalRecyclerView.layoutManager = LinearLayoutManager(this)

        val jsonData = AssetManager(this).readJsonFromAsset("smytten.json")

        val dataType = object : TypeToken<DataModel>() {}.type
        val dataModel: DataModel = Gson().fromJson(jsonData, dataType)

        viewModel.setDataModel(dataModel)

        val adapter = HomeAdapter(this,dataModel.content)
        verticalRecyclerView.adapter = adapter
    }
}