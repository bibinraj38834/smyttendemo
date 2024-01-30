package com.example.smyttendemo.utils

import android.content.Context
import java.io.IOException

class AssetManager(private val context: Context) {
    fun readJsonFromAsset(fileName: String): String {
        return try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }
}