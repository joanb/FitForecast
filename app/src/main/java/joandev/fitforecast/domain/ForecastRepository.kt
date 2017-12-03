package joandev.fitforecast.domain

import io.reactivex.Single
import joandev.fitforecast.domain.model.Forecast


/**
 * Created by Joan on 02/12/2017.
 */
interface ForecastRepository {

  fun getForecast(): Single<List<Forecast>>
}