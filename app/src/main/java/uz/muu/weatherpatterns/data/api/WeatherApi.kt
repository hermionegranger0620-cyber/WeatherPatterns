package uz.muu.weatherpatterns.data.api

import uz.muu.weatherpatterns.data.model.Weather

interface WeatherApi {
    suspend fun fetchWeather(city: String): Weather
}
