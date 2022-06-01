package com.example.myproject.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myproject.BR

/**
 * @author mumuxi
 * @version 2022/6/1
 */
class Person() : BaseObservable() {

    /*这里的次构造函数如果直接写作为主函数，可能会导致数据绑定默认值不出现
    作为主函数时，是直接设置name值的，但是如果是作为次构造函数时，
    是通过setName()方法设置的，这点是不一样的*/
    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    private var age: Int = 0

}