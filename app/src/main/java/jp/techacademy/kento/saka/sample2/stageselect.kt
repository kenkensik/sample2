package jp.techacademy.kento.saka.sample2


import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stageselect.*

class stageselect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Map<String, String> 型の ArrayList を作成します
        val list = ArrayList<Map<String, String>>()

        for (i in 0..10) {
            val map = HashMap<String, String>()
            map.put("main", "メイン $i")
            map.put("sub", "サブ $i")
            list.add(map)
        }

        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_2,
            arrayOf("main", "sub"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter

        listView.setOnItemClickListener {parent, view, position, id ->
            Log.d("UI_PARTS", "クリック $position")
        }
    }
}
