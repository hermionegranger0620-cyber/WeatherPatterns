package uz.muu.weatherpatterns.data.repository

import uz.muu.weatherpatterns.data.api.WeatherApi
import uz.muu.weatherpatterns.data.model.Weather

class WeatherRepository(private val api: WeatherApi) {

    suspend fun getWeather(city: String): Result<Weather> {
        // TODO 1: call api.fetchWeather(city)
        // TODO 2: return Result.success(weather) when it works
        // TODO 3: return Result.failure(e) when it throws IllegalArgumentException
        //         (no runCatching { }: it would swallow CancellationException too)
        // TODO("not implemented yet")

        try {
            val weather = api.fetchWeather(city)
            return Result.success(weather)
        } catch (e: IllegalArgumentException) {
            return Result.failure(e)
        }

    }
}

