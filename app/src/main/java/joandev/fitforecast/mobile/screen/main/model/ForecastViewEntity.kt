package joandev.fitforecast.mobile.screen.main.model

import joandev.fitforecast.domain.model.Forecast


/**
 * Created by Joan on 03/12/2017.
 */
class ForecastViewEntity(
    val time: String,
    val icon: String?,
    val temp: Float?,
    val humidity: Float?,
    val windSpeed: Float?,
    val rainVolume: Float?
)

fun List<Forecast>.mapToUi() = map { it.mapToUi() }

fun Forecast.mapToUi() = ForecastViewEntity(
    time,
    icon,
    temp,
    humidity,
    windSpeed,
    rainVolume
)