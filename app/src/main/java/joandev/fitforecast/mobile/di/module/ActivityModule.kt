package joandev.fitforecast.mobile.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides


/**
 * Created by Joan on 02/12/2017.
 */
@Module(includes = arrayOf(ViewModule::class))
class ActivityModule(val baseActivity: Activity) {

  @Provides
  fun providesActivity(): Activity {
    return baseActivity
  }
}