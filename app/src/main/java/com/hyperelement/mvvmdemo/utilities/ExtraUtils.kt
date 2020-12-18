package com.hyperelement.mvvmdemo.utilities

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import smartadapter.extension.SmartViewHolderBinder
import smartadapter.viewevent.model.ViewEvent
import smartadapter.viewevent.swipe.BasicSwipeEventBinder
import smartadapter.viewevent.swipe.SwipeFlags
import java.io.IOException
import java.io.InputStream


object ExtraUtils {
    //Ref: StackOverflow
    fun getJsonFromAssets(context: Context, fileName: String?): String? {
        val jsonString: String
        jsonString = try {
            val mInputStream: InputStream = context.assets.open(fileName)
            val size: Int = mInputStream.available()
            val buffer = ByteArray(size)
            mInputStream.read(buffer)
            mInputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}