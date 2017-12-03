package joandev.fitforecast.domain

import io.reactivex.Single


/**
 * Created by Joan on 02/12/2017.
 */
interface ForecastRepository {

  fun getForecast(): Single<Forecast> //TODO: think a better name
}