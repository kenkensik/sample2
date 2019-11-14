package jp.techacademy.kento.saka.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_stageselect.*
import kotlinx.android.synthetic.main.activity_stageselect.*

class MainActivity : AppCompatActivity() {
    private lateinit var mRealm: Realm
    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(element: Realm) {
            //reloadListView()
        }
    }

    private var task: data? = null

   // private lateinit var mDataAdapter: DataAdapter//追加

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var a: Int = 5

        button1.setOnClickListener {

            //val task = DataAdapter.getItem(1) as data
            //var taskList = mutableListOf<data>()
            //val task=taskList[1] as data
            //val task = data()
            //task.id=21
            //task.title="変更"
            val realm = Realm.getDefaultInstance()
            //var a:Int=1
            task = realm.where(data::class.java).equalTo("answer", false).findFirst()
            realm.close()
            if(task==null){

            }else {
                /*mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(task)
            mRealm.commitTransaction()*/

                val intent = Intent(this@MainActivity, stage1::class.java)
                intent.putExtra("VALUE1", task!!.value1)
                intent.putExtra("VALUE2", task!!.value2)
                //realm.close()

                intent.putExtra("VALUE3", task!!.id)
                startActivity(intent)
            }
            //val task = parent.adapter.getItem(1) as data
            /*when (a) {
                1 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 3)
                    intent.putExtra("VALUE2", 5)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                2 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 8)
                    intent.putExtra("VALUE2", 4)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                3 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 6)
                    intent.putExtra("VALUE2", 18)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                4 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 24)
                    intent.putExtra("VALUE2", 4)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                5 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 17)
                    intent.putExtra("VALUE2", 2)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                6 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 7)
                    intent.putExtra("VALUE2", 49)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                7 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 8)
                    intent.putExtra("VALUE2", 8)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                8 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 9)
                    intent.putExtra("VALUE2", 72)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                9 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 7)
                    intent.putExtra("VALUE2", 6)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }

                10 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 10)
                    intent.putExtra("VALUE2", 1024)
                    intent.putExtra("VALUE3", a)
                    startActivity(intent)
                }*/
            }



            mRealm = Realm.getDefaultInstance()
            mRealm.addChangeListener(mRealmListener)






        button2.setOnClickListener {
            Log.d("test", "hello")
            val intent = Intent(this, stageselect::class.java)
            startActivity(intent)
        }

        addTaskForTest()

    }


    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }

    private fun addTaskForTest() {

        for (i in 1..20) {
            val task = data()
            //var hako=arrayOf<Int>(1,1)
            //task.title = "stage" + i.toString()
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


