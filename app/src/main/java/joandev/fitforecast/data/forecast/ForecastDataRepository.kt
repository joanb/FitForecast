package joandev.fitforecast.data.forecast

import io.reactivex.Single
import joandev.fitforecast.data.forecast.datasources.ForecastDataSource
import joandev.fitforecast.domain.forecast.model.Forecast
import joandev.fitforecast.domain.repositories.ForecastRepository
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastDataRepository @Inject constructor(private val dataSources: List<ForecastDataSource>) : ForecastRepository {

  override fun getForecast(): Single<List<Forecast>> = dataSources.first().getForecast()
}