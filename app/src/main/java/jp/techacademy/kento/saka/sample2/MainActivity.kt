package jp.techacademy.kento.saka.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a: Int = 5

        button1.setOnClickListener {


            when (a) {
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
                }
            }


        }

        button2.setOnClickListener {
            Log.d("test", "hello")
            val intent = Intent(this, stageselect::class.java)
            startActivity(intent)
        }

    }

    }


