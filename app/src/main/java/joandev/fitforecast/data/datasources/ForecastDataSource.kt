package joandev.fitforecast.data.datasources

import io.reactivex.Single
import joandev.fitforecast.domain.Forecast


/**
 * Created by Joan on 02/12/2017.
 */
interface ForecastDataSource {

  fun getForecast() : Single<Forecast>
}