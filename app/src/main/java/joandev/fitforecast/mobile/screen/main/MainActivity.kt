package joandev.fitforecast.mobile.screen.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import joandev.fitforecast.R
import joandev.fitforecast.mobile.common.BaseActivity
import joandev.fitforecast.mobile.di.component.ActivityComponent
import joandev.fitforecast.mobile.screen.main.model.ForecastViewEntity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.MainView {

  @Inject lateinit var presenter: MainPresenter
  val forecastAdapter by lazy { ForecastRecycerViewAdapter() }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter.onStart()
    presenter.getForecast()
  }

  override fun initializeViews() {
    if (forecasr_rv.adapter == null) {
      forecasr_rv.layoutManager = LinearLayoutManager(this)
      forecasr_rv.adapter = forecastAdapter
    }
  }

  override fun showForecast(forecastToShow: List<ForecastViewEntity>) {
    forecastAdapter.forecast = forecastToShow
  }

  override fun inject(component: ActivityComponent) {
    component.inject(this)
  }
}
