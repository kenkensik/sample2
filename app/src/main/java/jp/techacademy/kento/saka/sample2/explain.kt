package jp.techacademy.kento.saka.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_explain.*
import kotlinx.android.synthetic.main.activity_stage1.*

class explain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explain)

        text0a4.text="    1"

        button0a1.setOnClickListener {

            if(edit0a1.text.toString()==""||edit0a1.text.toString()=="1"){

                Snackbar.make(it, "1を除く1から100までの整数を入力してください", Snackbar.LENGTH_INDEFINITE)
                    .setAction("×"){
                    }.show()

            }else {
                val a = edit0a1.text.toString().toInt() + 1
                text0a3.text = a.toString()
            }
        }

        button0a3.setOnClickListener{

            if(edit0a2.text.toString()=="2"){
                textexplain0.text="正解です!!"
                textexplain1.text="このように規則を見破り、？の数を入力したらDECIDEを押しましょう"
                textexplain2.text="数があっていればstage clearです。"
                textexplain3.text=""
                textexplain4.text="注意点"
                textexplain5.text="freeに入力できるのは下の数(example stageでは1)を除く1～100の整数だけです。"
            }else{
                    Snackbar.make(it, "不正解", Snackbar.LENGTH_INDEFINITE)
                        .setAction("×"){
                        }.show()
                    //text1a7.text="不正解"

            }
        }
    }
}
