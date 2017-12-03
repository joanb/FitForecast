package joandev.fitforecast.mobile.screen.main

import android.os.Bundle
import joandev.fitforecast.R
import joandev.fitforecast.mobile.common.BaseActivity
import joandev.fitforecast.mobile.di.component.ActivityComponent
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.MainView {

  @Inject lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter.getForecast()
  }

  override fun inject(component: ActivityComponent) {
    component.inject(this)
  }
}
