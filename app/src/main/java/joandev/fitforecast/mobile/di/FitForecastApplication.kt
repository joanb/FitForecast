package joandev.fitforecast.mobile.di

import android.app.Application
import android.content.Context
import joandev.fitforecast.mobile.di.component.ApplicationComponent
import joandev.fitforecast.mobile.di.component.DaggerApplicationComponent
import joandev.fitforecast.mobile.di.module.ApplicationModule


/**
 * Created by Joan on 02/12/2017.
 */
class FitForecastApplication : Application() {


  val component: ApplicationComponent
    get () = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()

  override fun onCreate() {
    super.onCreate()
    component.inject(this)
  }


  companion object {
    operator fun get(context: Context): FitForecastApplication {
      return context.applicationContext as FitForecastApplication
    }
  }

}