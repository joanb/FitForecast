package joandev.fitforecast.data.di

import dagger.Module
import dagger.Provides
import joandev.fitforecast.data.forecast.ForecastDataRepository
import joandev.fitforecast.data.forecast.datasources.ForecastDataSource
import joandev.fitforecast.domain.repositories.ForecastRepository
import javax.inject.Named


/**
 * Created by Joan on 02/12/2017.
 */

@Module
class RepositoryModule {

  @Provides
  fun providesForecastRepository(@Named("remote") forecastRemoteDataSource: ForecastDataSource): ForecastRepository =
      ForecastDataRepository(listOf(forecastRemoteDataSource))
}