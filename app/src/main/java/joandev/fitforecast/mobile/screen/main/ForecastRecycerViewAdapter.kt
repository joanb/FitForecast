package joandev.fitforecast.mobile.screen.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import joandev.fitforecast.R
import joandev.fitforecast.mobile.screen.main.model.ForecastViewEntity
import kotlinx.android.synthetic.main.item_forecast.view.*


/**
 * Created by Joan on 03/12/2017.
 */
class ForecastRecycerViewAdapter : RecyclerView.Adapter<ForecastRecycerViewAdapter.ForecastViewHolder>() {

  var forecast = listOf<ForecastViewEntity>()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
    holder.bind(forecast[position])
  }

  override fun getItemCount() = forecast.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      ForecastViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false))


  class ForecastViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {

    fun bind(forecast: ForecastViewEntity) = with(rootView) {
      rain_tv.text = "Rain: ${forecast.rainVolume ?: "No rain expected"}"
      wind_tv.text = "Wind: ${forecast.windSpeed ?: "No data"}"
      temp_tv.text = "Temperature: ${forecast.temp ?: "No data"}"
    }
  }
}