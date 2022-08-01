package com.rimapps.PlayGround.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.PlayGround.databinding.ActivityHiltTestBinding
import com.rimapps.PlayGround.model.HiltTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity() {
    private lateinit var hiltTestBinding: ActivityHiltTestBinding
    private val hiltTestViewModel : HiltTestViewModel by viewModels()

    private val TAG: String = "AppDebug"
    
    /* Hilt will be looking to any modules for any dependencies that has type string and will inject here */
    @Inject
    lateinit var someRandomString:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hiltTestBinding = ActivityHiltTestBinding.inflate(layoutInflater)
        hiltTestBinding.tvHiltTest.text = someRandomString
        setContentView(hiltTestBinding.root)


        Log.d(TAG, "onCreate: $someRandomString")
    }
}