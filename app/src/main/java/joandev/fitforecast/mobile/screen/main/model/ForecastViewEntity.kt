package joandev.fitforecast.mobile.screen.main.model

import joandev.fitforecast.domain.forecast.model.Forecast


/**
 * Created by Joan on 03/12/2017.
 */
class ForecastViewEntity(
    val date: String,
    val time: String,
    val icon: String?,
    val temp: Float?,
    val windSpeed: Float?,
    val rainVolume: Float?
)

fun List<Forecast>.mapToUi() = map { it.mapToUi() }

fun Forecast.mapToUi(): ForecastViewEntity {
  val splitDate = time.split(" ")

  return ForecastViewEntity(
      splitDate[0],
      splitDate[1],
      "http://openweathermap.org/img/w/${icon}.png",
      temp,
      windSpeed,
      rainVolume
  )
}