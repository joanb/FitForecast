package joandev.fitforecast.domain.forecast.model


/**
 * Created by Joan on 03/12/2017.
 */
class Forecast(
    val time: String,
    val icon: String?,
    val temp: Float?,
    val windSpeed: Float?,
    val rainVolume: Float?
)