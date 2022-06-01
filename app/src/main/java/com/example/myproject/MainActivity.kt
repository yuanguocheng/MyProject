package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myproject.jetpack.DataBindingActivity
import com.example.myproject.utils.LogUtil

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val TAG = "MainActivity"
    }

    lateinit var bt_start_DataAndViewBindingActivity: Button
    var hasInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtil.d(TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.d(TAG, "onResume")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (!hasInit) {
            LogUtil.d(TAG, "onWindowFocusChanged")
            hasInit = true
            initView()
            initEvent()
        }
    }

    private fun initView() {
        bt_start_DataAndViewBindingActivity = findViewById(R.id.bt_start_DataAndViewBindingActivity)
    }

    private fun initEvent() {
        bt_start_DataAndViewBindingActivity.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.bt_start_DataAndViewBindingActivity -> startActivity(
                Intent(this, DataBindingActivity::class.java)
            )
        }

    }
}