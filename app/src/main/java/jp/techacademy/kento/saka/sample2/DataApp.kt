package jp.techacademy.kento.saka.sample2

import android.app.Application
import io.realm.Realm

class DataApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}