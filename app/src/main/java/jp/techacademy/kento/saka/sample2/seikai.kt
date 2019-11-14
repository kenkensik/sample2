package jp.techacademy.kento.saka.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_seikai.*

class seikai : AppCompatActivity() {

    private var task: data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seikai)

        next.setOnClickListener{
            val realm = Realm.getDefaultInstance()
            task = realm.where(data::class.java).equalTo("id", intent.getIntExtra("stage", 0)).findFirst()
            realm.close()

            val intent = Intent(this@seikai, stage1::class.java)
            intent.putExtra("VALUE1", task!!.value1)
            intent.putExtra("VALUE2", task!!.value2)
            //realm.close()

            intent.putExtra("VALUE3", task!!.id)
            startActivity(intent)


        }

        top.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
