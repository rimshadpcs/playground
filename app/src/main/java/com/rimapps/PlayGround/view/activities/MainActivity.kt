package com.rimapps.PlayGround.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.PlayGround.databinding.ActivityMainBinding
import com.rimapps.PlayGround.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val mainModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btStart.text = mainModel.startButton
        mainBinding.btStart.setOnClickListener{
            val intent = Intent(this, BubbleSample::class.java)
            startActivity(intent)
        }
    }
}