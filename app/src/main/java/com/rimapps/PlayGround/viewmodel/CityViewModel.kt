package com.rimapps.PlayGround.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.rimapps.PlayGround.model.City
import com.rimapps.PlayGround.model.CityDataProvider


class CityViewModel: ViewModel() {

    /*Mutable live data allows av iew to subscribe to events and receive notifications whenever the values changes,
    where as LiveData wont allow to change   */

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()

    //current city we displaying
    private var currentIndex = 0
    private val delay = 2000L

    // anything in init will be the first to be executed, once the class is instantiated
    init {
        loop()
    }
    //live data cannot be modified by the user
    fun getCityData(): LiveData<City> = cityData

    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({ updateCity() },delay)
    }
    //function to update current city
    private fun updateCity(){
        currentIndex++
        //if current city is at the end of the list, switch it to 0th index
        currentIndex %=cities.size

        cityData.value = cities[currentIndex]

        loop()
    }




}
