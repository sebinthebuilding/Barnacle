package random.barnacle

import android.app.Application
import random.barnacle.data.AppContainer
import random.barnacle.data.DefaultAppContainer

class BarnacleApplication : Application() {
    //lateinit needed bc 'container' will only exist once onCreate() exists.
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}