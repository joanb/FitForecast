package joandev.fitforecast.data.di

import dagger.Module
import dagger.Provides
import joandev.fitforecast.data.ForecastDataRepository
import joandev.fitforecast.data.datasources.ForecastDataSource
import joandev.fitforecast.domain.ForecastRepository
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