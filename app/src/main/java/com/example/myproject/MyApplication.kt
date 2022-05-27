package com.example.myproject

import android.app.Application
import android.content.Context
import com.example.myproject.utils.LogUtil

class MyApplication : Application() {


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        LogUtil.d("MyApplication", "attachBaseContext")
    }

    override fun onCreate() {
        super.onCreate()
        LogUtil.d("MyApplication", "onCreate")
        LogUtil.setLevel(LogUtil.ERROR)
        LogUtil.TAG = "YGC_TAG"
    }
}