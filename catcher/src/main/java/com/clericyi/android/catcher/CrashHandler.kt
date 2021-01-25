package com.clericyi.android.catcher

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.*
import kotlin.system.exitProcess

/**
 * author: ClericYi
 * time: 2021/01/25
 */
class CrashHandler(private val context: Context) : Thread.UncaughtExceptionHandler {

    private val TAG = "CrashHandler"
    private val FILE_PATH = context.filesDir.path + "/crash"

    private var defaultCrashHandler: Thread.UncaughtExceptionHandler? = null

    init {
        defaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }


    override fun uncaughtException(thread: Thread, e: Throwable) {
        if (!handleException(e)) {
            defaultCrashHandler?.uncaughtException(thread, e)
        } else {
            // App Exit
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }

    }

    private fun handleException(e: Throwable): Boolean {
        // save info to file
        saveCrashInfo2File(e)
        return true
    }

    private fun saveCrashInfo2File(e: Throwable) {
        val builder = StringBuffer()

        val writer = StringWriter()
        val printWriter = PrintWriter(writer)
        e.printStackTrace(printWriter)
        var cause = e.cause
        while (cause != null) {
            cause.printStackTrace(printWriter)
            cause = cause.cause
        }
        printWriter.close()

        builder.append(writer.toString())

        try {
            val currentTime = System.currentTimeMillis()
            val fileName = "crash-$currentTime.log"
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                val dir = File(FILE_PATH)
                if (!dir.exists()) {
                    dir.mkdirs()
                }
                val fos = FileOutputStream("${FILE_PATH}${fileName}")
                fos.write(builder.toString().toByteArray())
                fos.close()
            }
        } catch (e: Exception) {
            Log.e(TAG, "an error occur while writing file...", e)
        }
    }

}