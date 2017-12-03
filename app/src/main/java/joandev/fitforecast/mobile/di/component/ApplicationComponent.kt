package joandev.fitforecast.mobile.di.component

import dagger.Component
import joandev.fitforecast.data.di.DataSourceModule
import joandev.fitforecast.data.di.RepositoryModule
import joandev.fitforecast.mobile.di.FitForecastApplication
import joandev.fitforecast.mobile.di.module.ActivityModule
import joandev.fitforecast.mobile.di.module.ApplicationModule
import joandev.fitforecast.mobile.di.module.ViewModule
import javax.inject.Singleton


/**
 * Created by Joan on 02/12/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, RepositoryModule::class, DataSourceModule::class))
interface ApplicationComponent {
  val application: FitForecastApplication

  fun inject(application: FitForecastApplication)

  fun application(): FitForecastApplication

  fun plus(activityModule: ActivityModule, viewModule: ViewModule) : ActivityComponent
}