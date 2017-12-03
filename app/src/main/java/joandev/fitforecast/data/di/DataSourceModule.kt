package joandev.fitforecast.data.di

import dagger.Module
import dagger.Provides
import joandev.fitforecast.data.forecast.datasources.ForecastDataSource
import joandev.fitforecast.data.forecast.datasources.remote.ForecastRemoteDataSource
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


/**
 * Created by Joan on 02/12/2017.
 */

@Module
class DataSourceModule {

  @Provides
  fun providesRetrofit(): Retrofit =
      Retrofit.Builder()
          .baseUrl("http://api.openweathermap.org/")
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build()

  @Provides
  @Named("remote")
  fun providesRemoteForecastDataSource(forecastRemoteDataSource: ForecastRemoteDataSource): ForecastDataSource = forecastRemoteDataSource
}