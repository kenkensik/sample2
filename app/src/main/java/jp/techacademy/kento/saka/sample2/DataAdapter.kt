package jp.techacademy.kento.saka.sample2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class DataAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    var taskList = mutableListOf<data>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: mLayoutInflater.inflate(android.R.layout.simple_list_item_1, null)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)
        //val textView2 = view.findViewById<TextView>(android.R.id.text2)

        // 後でTaskクラスから情報を取得するように変更する
        textView1.text = taskList[position].title

        //val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        //val date = taskList[position].date
        //textView2.text = simpleDateFormat.format(date)
        return view //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        return taskList[position] //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        return taskList[position].id.toLong()//To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return taskList.size

    }
}