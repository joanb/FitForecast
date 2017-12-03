package joandev.fitforecast.data.model

import com.google.gson.annotations.SerializedName
import joandev.fitforecast.domain.model.Forecast


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastRemoteEntity(
    @SerializedName("list") val forecastList: List<ForecastDataEntity>
)

class ForecastDataEntity(
    @SerializedName("main") val mainInfo: MainForecastInfo,
    @SerializedName("wind") val wind: WindInfo,
    @SerializedName("rain") val rain: RainInfo?
)

class MainForecastInfo(
    @SerializedName("temp") val temperature: Float?,
    @SerializedName("humidity") val humidity: Float?
)

class WindInfo(
    @SerializedName("speed") val windSpeed: Float?
)

class RainInfo(
    @SerializedName("3h") val rainVolume: Float?
)


fun ForecastRemoteEntity.mapToDomain() : List<Forecast> {
  return mutableListOf<Forecast>().apply {
    forecastList.forEach {
      add(Forecast(
          "time", //TODO: get proper time
          it.mainInfo.temperature,
          it.mainInfo.humidity,
          it.wind.windSpeed,
          it.rain?.rainVolume
      ))
    }
  }


}