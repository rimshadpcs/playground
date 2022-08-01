package com.rimapps.PlayGround.model

import com.example.PlayGround.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init{
        cities.add(City("London", R.drawable.london, 120000))
        cities.add(City("Berlin", R.drawable.berlin, 132420))
        cities.add(City("New York", R.drawable.newyork,200202))
        cities.add(City("Madrid", R.drawable.madrid,5427682))
        cities.add(City("Amsterdam", R.drawable.amsterdam,453213))
        cities.add(City("Paris", R.drawable.paris,142621))
        cities.add(City("Rome", R.drawable.rome,125312))
    }

    //method to get cities in CityViewModel
    fun getCities() = cities
}