package joandev.fitforecast.mobile.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import joandev.fitforecast.mobile.di.FitForecastApplication
import joandev.fitforecast.mobile.di.component.ActivityComponent
import joandev.fitforecast.mobile.di.module.ActivityModule
import joandev.fitforecast.mobile.di.module.ViewModule


/**
 * Created by Joan on 02/12/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initializeDependencyInjection()
  }

  private fun initializeDependencyInjection() {
    val component = (application as FitForecastApplication).component.plus(ActivityModule(this),  ViewModule(this))
    inject(component)
  }

  abstract fun inject(component: ActivityComponent)
}