package joandev.fitforecast.data.forecast.datasources.remote

import io.reactivex.Single
import joandev.fitforecast.data.forecast.datasources.ForecastDataSource
import joandev.fitforecast.data.forecast.model.ForecastRemoteEntity
import joandev.fitforecast.data.forecast.model.mapToDomain
import joandev.fitforecast.domain.forecast.model.Forecast
import retrofit2.Retrofit
import retrofit2.http.GET
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastRemoteDataSource @Inject constructor(private val retrofit: Retrofit) : ForecastDataSource {

  @Throws(IOException::class)
  override fun getForecast(): Single<List<Forecast>> =
      retrofit.create(ForecastApi::class.java).getForecast().map { it.mapToDomain() }
}

interface ForecastApi {

  @GET("data/2.5/forecast?id=3104324&APPID=6cb7dfd0bcb844db53c39ae10911a5e9&units=metric")
  fun getForecast(): Single<ForecastRemoteEntity>
}