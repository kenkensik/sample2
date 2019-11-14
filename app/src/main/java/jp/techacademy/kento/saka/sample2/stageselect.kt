package jp.techacademy.kento.saka.sample2

import io.realm.Sort
import io.realm.RealmChangeListener
import io.realm.Realm
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stageselect.*
import java.util.Date

class stageselect : AppCompatActivity() {
    private lateinit var mRealm: Realm
    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(element: Realm) {
            reloadListView()
        }
    }

    private lateinit var mDataAdapter: DataAdapter//追加

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stageselect)

        // Map<String, String> 型の ArrayList を作成します
        val list = ArrayList<Map<String, String>>()

        for (i in 1..10) {
            val map = HashMap<String, String>()
            map.put("main", "stage $i")
            //map.put("sub", "サブ $i")
            list.add(map)
        }

        /*val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_1,
            arrayOf("main", "sub"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter*/
        var a=1

        listView.setOnItemClickListener {parent, view, position, id ->
            when(position+1){
                1 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 3)
                    intent.putExtra("VALUE2", 5)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                2 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 8)
                    intent.putExtra("VALUE2", 4)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                3 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 6)
                    intent.putExtra("VALUE2", 18)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                4 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 24)
                    intent.putExtra("VALUE2", 4)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                5 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 17)
                    intent.putExtra("VALUE2", 2)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                6 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 7)
                    intent.putExtra("VALUE2", 49)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                7 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 8)
                    intent.putExtra("VALUE2", 8)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                8 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 9)
                    intent.putExtra("VALUE2", 72)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                9 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 7)
                    intent.putExtra("VALUE2", 6)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }

                10 -> {
                    val intent = Intent(this, stage1::class.java)
                    intent.putExtra("VALUE1", 10)
                    intent.putExtra("VALUE2", 1024)
                    intent.putExtra("VALUE3", position+1)
                    startActivity(intent)
                }
            }

            Log.d("UI_PARTS", "クリック $position+1")
            }

        mRealm = Realm.getDefaultInstance()
        mRealm.addChangeListener(mRealmListener)

        mDataAdapter = DataAdapter(this@stageselect)

        //addTaskForTest()

        // ListViewをタップしたときの処理
        listView.setOnItemClickListener { parent, view, position, id ->
            // 入力・編集する画面に遷移させる
            //Log.d("test",(position+1).toString())
            val task = parent.adapter.getItem(position) as data
            //Log.d("test",parent)

            //val task = data()
            //task.id = position+1
            //Log.d("test",task.value1.toString())
            val intent = Intent(this@stageselect, stage1::class.java)
            intent.putExtra("VALUE1", task.value1)
            intent.putExtra("VALUE2", task.value2)
            intent.putExtra("VALUE3", task.id)
            startActivity(intent)

        }

        // ListViewを長押ししたときの処理
        listView.setOnItemLongClickListener { parent, view, position, id ->
            // タスクを削除する
            true
        }



        reloadListView()

        }

    override fun onResume() {

        super.onResume()

        reloadListView()
    }


    private fun reloadListView() {
        // 後でTaskクラスに変更する
        //val taskList = mutableListOf("aaa", "bbb", "ccc")

        //val taskRealmResults = mRealm.where(data::class.java).findAll().sort("date", Sort.DESCENDING)
        val taskRealmResults = mRealm.where(data::class.java).findAll().sort("id", Sort.ASCENDING)

        mDataAdapter.taskList = mRealm.copyFromRealm(taskRealmResults)

        //mDataAdapter.taskList=taskList
        listView.adapter = mDataAdapter
        mDataAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()

        mRealm.close()
    }

    private fun addTaskForTest() {

        for(i in 1..20) {
            val task = data()
            //var hako=arrayOf<Int>(1,1)
            task.title = "stage"+i.toString()
            //task.contents = "プログラムを書いてPUSHする"
            //task.date = Date()
            task.id = i

            //Log.d("test",i.toString())
            when(i){
                1->{ task.value1=3
                     task.value2=5
                }
                2->{ task.value1=8
                    task.value2=4
                }
                3->{ task.value1=6
                    task.value2=18
                }
                4->{ task.value1=24
                    task.value2=4
                }
                5->{ task.value1=17
                    task.value2=2
                }
                6->{ task.value1=7
                    task.value2=49
                }
                7->{ task.value1=8
                    task.value2=8
                }
                8->{ task.value1=9
                    task.value2=72
                }
                9->{ task.value1=7
                    task.value2=6
                }
                10->{ task.value1=10
                    task.value2=1024
                }
            }

            mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(task)
            mRealm.commitTransaction()

        }




        }



    }


