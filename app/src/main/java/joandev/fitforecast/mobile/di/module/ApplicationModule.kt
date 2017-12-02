package joandev.fitforecast.mobile.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import joandev.fitforecast.mobile.di.FitForecastApplication
import javax.inject.Singleton


/**
 * Created by Joan on 02/12/2017.
 */
@Module
class ApplicationModule(val application: FitForecastApplication) {

  @Provides
  @Singleton
  fun providesApplication(): FitForecastApplication {
    return application
  }

  @Provides
  @Singleton
  fun providesApplicationContext(): Context {
    return application
  }
}