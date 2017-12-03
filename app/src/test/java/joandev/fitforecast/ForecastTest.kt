package joandev.fitforecast

import joandev.fitforecast.data.forecast.model.*
import joandev.fitforecast.domain.forecast.model.Forecast
import joandev.fitforecast.mobile.screen.main.model.mapToUi
import org.junit.Test


/**
 * Created by Joan on 03/12/2017.
 */
class ForecastTest {

  @Test
  fun should_map_all_ForecastRemoteEntity_when_mapToDomain_is_Executed() {
    val remoteForecast = givenACorrectRemoteForecast()

    val domainForecast = remoteForecast.mapToDomain().first()

    domainForecast.time shouldBe  remoteForecast.forecastList.first().time
    domainForecast.icon shouldBe  remoteForecast.forecastList.first().weather?.first()?.icon
    domainForecast.temp shouldBe  remoteForecast.forecastList.first().mainInfo.temperature
    domainForecast.windSpeed shouldBe  remoteForecast.forecastList.first().wind.windSpeed
    domainForecast.rainVolume shouldBe  remoteForecast.forecastList.first().rain?.rainVolume
  }

  @Test
  fun should_map_domain_forecast_to_UI_forecast_when_mapToUI_isexecuted() {
    val domainForecast = Forecast("2017-12-08 03:00:00", "foo", 1.0f, 2.0f, 0.0f)

    val viewForecast = domainForecast.mapToUi()

    viewForecast.date shouldBe "2017-12-08"
    viewForecast.time shouldBe "03:00:00"
    viewForecast.icon shouldBe "http://openweathermap.org/img/w/${domainForecast.icon}.png"
    viewForecast.temp shouldBe domainForecast.temp
    viewForecast.windSpeed shouldBe domainForecast.windSpeed
    viewForecast.rainVolume shouldBe domainForecast.rainVolume
  }


  fun givenACorrectRemoteForecast() =
      ForecastRemoteEntity(listOf(ForecastDataEntity(
          MainForecastInfo(temperature = 2.0F),
          WindInfo(windSpeed = 5.5F),
          RainInfo(rainVolume = 0.1F),
          listOf(Weather(icon = "foo")),
          time = "2017-12-08 03:00:00"
      )))
}