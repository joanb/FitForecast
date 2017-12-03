package joandev.fitforecast.mobile.screen.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import joandev.fitforecast.R
import joandev.fitforecast.mobile.common.load
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
      icon_iv.load(forecast.icon)
      date_tv.text = forecast.date
      time_tv.text = forecast.time
      rain_tv.text = "${forecast.rainVolume ?: "0"} l/m2"
      wind_tv.text = "${forecast.windSpeed ?: "No data"} km/h"
      temp_tv.text = "${forecast.temp ?: "No data"} ºC"
    }
  }
}