package joandev.fitforecast.mobile.screen.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import joandev.fitforecast.domain.GetForecast
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class MainPresenter @Inject constructor(private val view: MainView,
                                        private val getForecast: GetForecast) {

  fun getForecast() {
    getForecast.execute().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
        { println() },
        { println() }
    )
  }

  interface MainView {

  }
}