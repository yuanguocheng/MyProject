package com.example.myproject.jetpack


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.bean.Person
import com.example.myproject.databinding.ActivityDataBindingBinding

/**
 * learn at https://developer.android.google.cn/topic/libraries/data-binding
 * @author mumuxi
 * @version 2022/6/1
 */
class DataBindingActivity : AppCompatActivity() {

    lateinit var person: Person

    private lateinit var mEventListener: EventListener

    private lateinit var dataAndViewBindingBinding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        dataAndViewBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        person = Person("mumuxi", 28)

        dataAndViewBindingBinding.person = person

        mEventListener = EventListener()

        dataAndViewBindingBinding.eventListener = mEventListener

    }

    inner class EventListener {

        var count: Int = 1

        fun onClick(view: View?) {
            when (view?.id) {
                R.id.bt_change_name -> {
                    person.name = "gaga$count"
                    count++
                }

                R.id.bt_test -> {
                    person.name = "baba$count"
                    count++
                }
            }

        }
    }
}