package joandev.fitforecast.data.di

import dagger.Module
import dagger.Provides
import joandev.fitforecast.data.datasources.ForecastDataSource
import joandev.fitforecast.data.datasources.remote.ForecastRemoteDataSource
import javax.inject.Named


/**
 * Created by Joan on 02/12/2017.
 */

@Module
class DataSourceModule {

  @Provides
  @Named("remote")
  fun providesRemoteForecastDataSource(forecastRemoteDataSource: ForecastRemoteDataSource): ForecastDataSource = forecastRemoteDataSource
}