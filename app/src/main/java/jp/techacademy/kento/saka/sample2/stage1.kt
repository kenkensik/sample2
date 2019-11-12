package jp.techacademy.kento.saka.sample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stage1.*

class stage1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage1)

        text1a4.text="       "+intent.getIntExtra("VALUE1", 0).toString()

        button1a1.setOnClickListener {

            if(edit1a1.text.toString()==""||edit1a1.text.toString()==intent.getIntExtra("VALUE1", 0).toString()){

            }else {
                when(intent.getIntExtra("VALUE3", 0)){

                     1->generate1()
                     2->generate2()
                    3->generate3()
                    4->generate4()
                    5->generate5()
                    6->generate6()
                    7->generate7()
                    8->generate8()
                    9->generate9()
                    10->generate10()
                }

            }
        }

        button1a2.setOnClickListener{

            if(edit1a2.text.toString()==intent.getIntExtra("VALUE2", 0).toString()){

                val intent = Intent(this, seikai::class.java)
                startActivity(intent)
                //text1a7.text="正解"

            }else {

                text1a7.text="不正解"

            }

        }

    }

    fun generate1(){
        val a = edit1a1.text.toString().toInt() + 2
        text1a3.text = a.toString()
    }

    fun generate2(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }

    fun generate3(){
        val a = edit1a1.text.toString().toInt() *3
        text1a3.text = a.toString()

    }

    fun generate4(){
        val a = edit1a1.text.toString().toInt() /6
        text1a3.text = a.toString()

    }

    fun generate5(){
        val a = edit1a1.text.toString().toInt() %5
        text1a3.text = a.toString()

    }

    fun generate6(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }

    fun generate7(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }

    fun generate8(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }

    fun generate9(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }

    fun generate10(){
        val a = edit1a1.text.toString().toInt() - 4
        text1a3.text = a.toString()

    }
}
