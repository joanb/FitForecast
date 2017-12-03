package joandev.fitforecast.data

import io.reactivex.Single
import joandev.fitforecast.data.datasources.ForecastDataSource
import joandev.fitforecast.domain.Forecast
import joandev.fitforecast.domain.ForecastRepository
import javax.inject.Inject


/**
 * Created by Joan on 02/12/2017.
 */
class ForecastDataRepository @Inject constructor(val datasources: List<ForecastDataSource>) : ForecastRepository {

  override fun getForecast(): Single<Forecast> = datasources.first().getForecast()
}