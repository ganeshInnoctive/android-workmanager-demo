package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object {
        const val KEY_WORKER = "key_worker"
    }

    override fun doWork(): Result {
        return try {

            val count = inputData.getInt(MainActivity.KEY_COUNT_VALUE, 0)

            for (i in 0..count) {
                Log.i("MyTag", "i : $i")
            }

            val time = SimpleDateFormat("dd/MM/yyyy_hh:mm:ss")
            val currentDate = time.format(Date())

            val outputData = Data.Builder().putString(KEY_WORKER, currentDate).build()

            Result.success(outputData)
        } catch (e: Exception) {
            Result.failure()
        }
    }
}