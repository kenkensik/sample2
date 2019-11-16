package jp.techacademy.kento.saka.sample2

import android.app.Application
import io.realm.Realm
import io.realm.RealmChangeListener
import android.preference.PreferenceManager

class DataApp: Application() {

    private lateinit var mRealm: Realm
    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(element: Realm) {
            //reloadListView()
        }
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val preference = PreferenceManager.getDefaultSharedPreferences(this)

        mRealm = Realm.getDefaultInstance()
        mRealm.addChangeListener(mRealmListener)

        if(preference.getString("TEXT", "0")=="0") {
            addTaskForTest()
            val editor = preference.edit()
            editor.putString("TEXT", "1")
            editor.commit()
        }

    }


    private fun addTaskForTest() {

        for (i in 1..20) {
            val task = data()
            //var hako=arrayOf<Int>(1,1)
            task.title = "stage" + i.toString()
            //task.contents = "プログラムを書いてPUSHする"
            //task.date = Date()
            task.id = i

            //Log.d("test",i.toString())
            when (i) {
                1 -> {
                    task.value1 = 3
                    task.value2 = 5
                }
                2 -> {
                    task.value1 = 8
                    task.value2 = 4
                }
                3 -> {
                    task.value1 = 6
                    task.value2 = 18
                }
                4 -> {
                    task.value1 = 24
                    task.value2 = 4
                }
                5 -> {
                    task.value1 = 17
                    task.value2 = 2
                }
                6 -> {
                    task.value1 = 7
                    task.value2 = 49
                }
                7 -> {
                    task.value1 = 8
                    task.value2 = 8
                }
                8 -> {
                    task.value1 = 9
                    task.value2 = 72
                }
                9 -> {
                    task.value1 = 7
                    task.value2 = 6
                }
                10 -> {
                    task.value1 = 10
                    task.value2 = 1024
                }
            }

            mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(task)
            mRealm.commitTransaction()

        }

    }
}