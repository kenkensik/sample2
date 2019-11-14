package jp.techacademy.kento.saka.sample2

import java.io.Serializable
import java.util.Date
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class data : RealmObject(), Serializable {
    var title:String=""
    var value1 :Int=0
    var value2  :Int=0
    var answer:Boolean=false
    var date:Date=Date()
    // id をプライマリーキーとして設定
    @PrimaryKey
    var id: Int = 0
}