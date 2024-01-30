package com.example.smyttendemo.ui.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smyttendemo.model.ContentItem
import com.example.smyttendemo.model.DataModel

class HomeViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<ContentItem>>()
    val dataList: LiveData<List<ContentItem>> get() = _dataList

    fun setDataModel(dataModel: DataModel) {
        // Update _dataList with the content items
        _dataList.value = dataModel.content
    }
}
