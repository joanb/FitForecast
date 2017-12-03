package joandev.fitforecast.mobile.screen.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import joandev.fitforecast.domain.forecast.usecase.GetForecast
import joandev.fitforecast.mobile.screen.main.model.ForecastViewEntity
import joandev.fitforecast.mobile.screen.main.model.mapToUi
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class MainPresenter @Inject constructor(private val view: MainView,
                                        private val getForecast: GetForecast) {


  fun onStart() {
    view.initializeViews()
  }
  fun getForecast() {
    getForecast.execute().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
        { view.showForecast(it.mapToUi()) },
        { println() }
    )
  }

  interface MainView {
    fun initializeViews()
    fun showForecast(mapToUi: List<ForecastViewEntity>)
  }
}