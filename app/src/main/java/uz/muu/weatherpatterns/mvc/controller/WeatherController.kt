package uz.muu.weatherpatterns.mvc.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import uz.muu.weatherpatterns.data.model.Weather
import uz.muu.weatherpatterns.data.repository.WeatherRepository
import uz.muu.weatherpatterns.mvc.model.WeatherModel
import uz.muu.weatherpatterns.mvc.view.WeatherView

class WeatherController(
    private val model: WeatherModel,
    private val view: WeatherView,
    private val scope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main),
) {

    fun onCitySelected(city: String) {
        scope.launch {
            // TODO 1: put the Model into the loading state, then ask the View
            //         to render
            // TODO 2: let the Model load `city` (it suspends until the data arrives)
            // TODO 3: ask the View to render again

            scope.launch {
                model.startLoading()
                view.render()
                model.load(city)
                view.render()
            }

        }
    }
}