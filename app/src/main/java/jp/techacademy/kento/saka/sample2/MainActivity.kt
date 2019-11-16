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


        button1.setOnClickListener {


            val realm = Realm.getDefaultInstance()
            //var a:Int=1
            task = realm.where(data::class.java).equalTo("answer", false).findFirst()
            realm.close()
            if(task==null){

            }else {

                val intent = Intent(this@MainActivity, stage1::class.java)
                intent.putExtra("VALUE1", task!!.value1)
                intent.putExtra("VALUE2", task!!.value2)
                //realm.close()

                intent.putExtra("VALUE3", task!!.id)
                startActivity(intent)
            }

            }

            mRealm = Realm.getDefaultInstance()
            mRealm.addChangeListener(mRealmListener)


        button2.setOnClickListener {
            Log.d("test", "hello")
            val intent = Intent(this, stageselect::class.java)
            startActivity(intent)
        }

        //addTaskForTest()
        //onDestroy()
    }


    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }


}


