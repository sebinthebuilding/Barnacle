package random.barnacle

import android.app.Application

class App : Application() {
    //lateinit needed bc 'container' will only exist once onCreate() exists.
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}