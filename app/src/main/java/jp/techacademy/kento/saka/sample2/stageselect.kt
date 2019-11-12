package jp.techacademy.kento.saka.sample2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stageselect.*

class stageselect : AppCompatActivity() {

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

        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_1,
            arrayOf("main", "sub"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter
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

        }
    }

