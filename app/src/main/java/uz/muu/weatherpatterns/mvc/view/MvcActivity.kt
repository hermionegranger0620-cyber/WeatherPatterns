package uz.muu.weatherpatterns.mvc.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.muu.weatherpatterns.di.WeatherModule
import uz.muu.weatherpatterns.mvc.controller.WeatherController
import uz.muu.weatherpatterns.mvc.model.WeatherModel
import uz.muu.weatherpatterns.mvc.view.ui.theme.WeatherPatternsTheme
import uz.muu.weatherpatterns.ui.WeatherScreen

class MvcActivity : ComponentActivity(), WeatherView {

    private val model = WeatherModel(WeatherModule.repository)
    private val controller = WeatherController(model, view = this)
    private var status by mutableStateOf("Pick a city")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WeatherScreen(status = status, onCitySelected = controller::onCitySelected)
            }
        }
    }

    override fun render() {
        // TODO: READ the Model (isLoading, error, weather) and set `status`
        //       "Loading…"  |  "Error: <message>"  |  "Tashkent: 24°C, Sunny"

        val weather = model.weather
        status = when {
            model.isLoading -> "Loading..."
            model.error != null -> "Error: ${model.error}"
            else -> "${weather?.city}: ${weather?.temperatureC}°C, ${weather?.condition}"
        }

    }
}