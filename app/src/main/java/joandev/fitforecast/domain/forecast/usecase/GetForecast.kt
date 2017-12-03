package joandev.fitforecast.domain.forecast.usecase

import joandev.fitforecast.domain.repositories.ForecastRepository
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class GetForecast @Inject constructor(private val repository: ForecastRepository) {

  fun execute() = repository.getForecast()
}