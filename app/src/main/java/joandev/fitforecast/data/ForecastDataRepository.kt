package joandev.fitforecast.data

import io.reactivex.Single
import joandev.fitforecast.data.datasources.ForecastDataSource
import joandev.fitforecast.domain.repositories.ForecastRepository
import joandev.fitforecast.domain.forecast.model.Forecast
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastDataRepository @Inject constructor(private val dataSources: List<ForecastDataSource>) : ForecastRepository {

  override fun getForecast(): Single<List<Forecast>> = dataSources.first().getForecast()
}