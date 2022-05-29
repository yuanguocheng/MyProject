package com.example.myproject.utils

import android.util.Log
import androidx.annotation.IntDef
import com.example.myproject.BuildConfig


/**
 * @author mumuxi
 * @version 2022/5/27
 *
 * Log 工具
 */
object LogUtil {

    const val VERBOSE = 1
    const val DEBUG = 2
    const val INFO = 3
    const val WARN = 4
    const val ERROR = 5

    private var level = VERBOSE
    private val IS_DEBUG = BuildConfig.DEBUG
    var TAG = "MyProject"

    private const val logMaxLength = 2000
    private const val logShowMaxRow = 100

    /**
     * debug message
     */
    fun d(tag: String, msg: String) {
        if (IS_DEBUG || level <= DEBUG) {
            printLog(tag, msg, Log.DEBUG)
        }
    }

    fun d(msg: String) {
        d(TAG, msg)
    }

    /**
     * warning message
     */
    fun i(tag: String, msg: String) {
        if (IS_DEBUG || level <= INFO) {
            printLog(tag, msg, Log.INFO)
        }
    }

    fun i(msg: String) {
        i(TAG, msg)
    }

    /**
     * warning message
     */
    fun w(tag: String, msg: String) {
        if (IS_DEBUG || level <= WARN) {
            printLog(tag, msg, Log.WARN)
        }
    }

    fun w(msg: String) {
        w(TAG, msg)
    }

    /**
     * error message
     */
    fun e(tag: String, msg: String) {
        if (IS_DEBUG || level <= ERROR) {
            printLog(tag, msg, Log.ERROR)
        }
    }

    fun e(msg: String) {
        e(TAG, msg)
    }

    private fun printLog(tag: String, msg: String, @PrintLogLevel level: Int) {
        val strLength = msg.length
        var start = 1
        var end = logMaxLength
        for (i in 1..logShowMaxRow) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                log(tag + i, msg.substring(start, end), level)
                start = end
                end += logMaxLength
            } else {
                log(tag, msg.substring(start, strLength), level)
                break
            }
        }
    }

    fun setLevel(@LogLevel level: Int) {
        this.level = level
    }

    /**
     * @param tag
     * @param message
     * @param level   Log工具方法的选择 ，Log.DEBUG 对应 Log.d()
     */
    private fun log(tag: String, message: String, level: Int) {
        when (level) {
            Log.DEBUG -> Log.d(tag, message)
            Log.INFO -> Log.i(tag, message)
            Log.WARN -> Log.w(tag, message)
            Log.ERROR -> Log.e(tag, message)
            else -> {}
        }
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(VERBOSE, DEBUG, INFO, WARN, ERROR)
    @Target(AnnotationTarget.VALUE_PARAMETER)
    internal annotation class LogLevel

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(
        Log.DEBUG,
        Log.INFO,
        Log.WARN,
        Log.ERROR
    )
    @Target(AnnotationTarget.VALUE_PARAMETER)
    internal annotation class PrintLogLevel
}