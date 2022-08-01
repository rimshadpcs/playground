package com.rimapps.PlayGround.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.PlayGround.databinding.ActivitySlidingBinding
import com.rimapps.PlayGround.viewmodel.CityViewModel

class SlidingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlidingBinding
    private val model: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySlidingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume(){
        super.onResume()

        model.getCityData().observe(this, Observer {city ->

            binding.ivCity.setImageDrawable(
               ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.tvCity.text = city.name
            binding.tvPopulation.text = city.population.toString()
        }

        )
    }
}