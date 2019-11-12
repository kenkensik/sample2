package jp.techacademy.kento.saka.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import kotlinx.android.synthetic.main.activity_seikai.*

class seikai : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seikai)

        next.setOnClickListener{

        }

        top.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
