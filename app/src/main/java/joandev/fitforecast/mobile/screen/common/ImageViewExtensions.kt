package joandev.fitforecast.mobile.screen.common

import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * Created by Joan on 03/12/2017.
 */
fun ImageView.load(url: String?) {
  Glide.with(context).load(url).into(this)
}