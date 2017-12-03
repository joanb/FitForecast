package joandev.fitforecast.data.datasources.remote

import io.reactivex.Single
import joandev.fitforecast.data.datasources.ForecastDataSource
import joandev.fitforecast.domain.Forecast
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastRemoteDataSource @Inject constructor() : ForecastDataSource {

  val forecastApiKey = "6cb7dfd0bcb844db53c39ae10911a5e9"

  val urlString = "http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=$forecastApiKey"
  @Throws(IOException::class)
  override fun getForecast(): Single<Forecast> = Single.create<Forecast> { emitter ->
    var inputStream: InputStream? = null
    try {
      val url = URL(urlString)
      val conn = url.openConnection() as HttpURLConnection
      conn.requestMethod = "GET"
      conn.connect()

      inputStream = conn.inputStream
      val result: String = inputStream.bufferedReader().use { it.readText() }
      emitter.onSuccess(Forecast())

    } finally {
      if (inputStream != null) {
        inputStream.close()
      }
    }
  }
}