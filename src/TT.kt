import com.tznin.http.Config
import com.tznin.http.HttpClientFromDouyu
import name.yumao.douyu.util.JsInServer
import java.util.*
import java.util.UUID



fun printMessageWithPrefix(message:Collection<String>, prefix: String) {
    message.forEach{
        println("$it $prefix")
    }
}

data class Person(val name:String, val age :Int)

fun <T:Comparable<T> > max(first:T , second:T) :T {
    return if(first > second) first else second
}

fun  main(args: Array<String>) {


//    val vo = HttpClientFromDouyu.QueryDouyuDownloadUrl(52319,"")
//    println(vo)
////
    val uuid = UUID.randomUUID().toString().replace("-".toRegex(), "")
    val time = (System.currentTimeMillis() / 1000).toString()
  //  ub98484234 = js_ctx.call('ub98484234', 279256, did, time)
    var jsdata = JsInServer.jsrun(279256, uuid,time)

    var jsdata2 = JsInServer.jsrun(279256, uuid,time)

    println(jsdata)
    println(jsdata2)

//    val  errors = listOf("403 nont", "404 not found")
//    printMessageWithPrefix(errors, ",")
//
//    val lis2t = listOf(1,2,3,4)
//    println(lis2t.filter { it % 2 == 0 } )
//
//    val listPerson  = listOf(Person("abc",20), Person("bbb",31) )
//    println(listPerson.filter { it.age > 20  })
//
//
//    println(listPerson.map { it.age })
//
//    val maxAge = listPerson.maxBy( Person::age )
//
//    val list2  = listOf(1,2,3)
//    println(list2.all { it == 3 } )
//    println(list2.any { it == 3 } )
//
//
//    val list = listOf("aaa","bbb","c")
//    println(list.groupBy(String::first) )
//
//
//    val strings = listOf("abc","123")
//    println(strings.flatMap { it.toList() }  )
//
//    val items = listOf("one","2",3)
//    println(items.filterIsInstance<String>() )
}