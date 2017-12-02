package joandev.fitforecast.mobile.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import joandev.fitforecast.mobile.screen.main.MainPresenter


/**
 * Created by Joan on 02/12/2017.
 */
@Module
class ViewModule (val activity: Activity) {

  @Provides
  fun providesMainView(): MainPresenter.MainView = activity as MainPresenter.MainView
}