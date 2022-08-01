package com.rimapps.PlayGround.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.PlayGround.databinding.ActivityBubbleSampleBinding
import com.rimapps.PlayGround.viewmodel.BubbleViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named
@AndroidEntryPoint
class BubbleSample : AppCompatActivity() {

    @Inject
    @Named("bubbleSampleMessage")
    lateinit var bubbleSampleMessage: String
    @Inject
    @Named("bubbleSampleButton")
    lateinit var bubbleSampleButton: String

    private val bubbleViewModel: BubbleViewModel by viewModels()
    private lateinit var bubbleBinding: ActivityBubbleSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bubbleBinding = ActivityBubbleSampleBinding.inflate(layoutInflater)
        setContentView(bubbleBinding.root)

        bubbleBinding.tvMessage.text = bubbleSampleMessage
        bubbleBinding.btContinue.text = bubbleSampleButton
        bubbleBinding.btContinue.setOnClickListener{
            val intent = Intent(this, McqActivity::class.java)
            intent.putExtra("FROM", 0)
            startActivity(intent)

        }

    }
}