package uz.hamroev.linuxgo.app

import android.app.Application
import com.onesignal.OneSignal
import uz.hamroev.linuxgo.cache.Cache

const val ONESIGNAL_APP_ID = "3278fd94-a32b-4a6d-aa8e-63e78e83268d"

class App: Application() {


    override fun onCreate() {
        super.onCreate()

        Cache.init(this)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

    }
}