package joandev.fitforecast.mobile.di.component

import dagger.Subcomponent
import joandev.fitforecast.mobile.di.module.ActivityModule
import joandev.fitforecast.mobile.di.module.ViewModule
import joandev.fitforecast.mobile.di.scope.PerActivity
import joandev.fitforecast.mobile.screen.main.MainActivity


/**
 * Created by Joan on 02/12/2017.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class, ViewModule::class))
interface ActivityComponent {
  fun inject(mainActivity: MainActivity)
}