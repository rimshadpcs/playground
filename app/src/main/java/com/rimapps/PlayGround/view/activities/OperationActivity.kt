package com.rimapps.PlayGround.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.PlayGround.R
import com.example.PlayGround.databinding.ActivityOperationBinding
import com.rimapps.PlayGround.services.MyNotificationManager


class OperationActivity : AppCompatActivity() {

    private lateinit var operationBinding: ActivityOperationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        operationBinding = ActivityOperationBinding.inflate(layoutInflater)
        setContentView(operationBinding.root)

        /* button click to send notification*/
        operationBinding.btSend.setOnClickListener {
            operationBinding.tvNotificationSend.text = getText(R.string.notificationSentChangeText)
            val notificationWorker: WorkRequest = OneTimeWorkRequestBuilder<MyNotificationManager>().build()
            WorkManager
                .getInstance(this)
                .enqueue(notificationWorker)

        }


    }
}