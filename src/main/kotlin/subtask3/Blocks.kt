package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val types = blockB.java.simpleName
        var objects: Any = ""
        if("String" == types) objects = typeString(blockA)
        else if ("int" == types) objects = typeInt(blockA)
        else if ("LocalDate" == types) objects = typeLocalDate(blockA)
//        println(objects)
        return objects
    }

    private fun typeString (blockA: Array<*>):String {
        var newStr = ""
        for (a in blockA) {
            if (a is String) newStr += a
        }
        return newStr
    }

    private fun typeInt (blockA: Array<*>): Int {
        var sum = 0
        for (a in blockA) {
            if (a is Int) sum += a
        }
        return sum
    }

    private fun typeLocalDate (blockA: Array<*>): String {
        var date = LocalDate.MIN
        for (a in blockA) {
            if (a is LocalDate){
                if (a > date) {
                    date = a
                }
            }
        }
        val formatter = DateTimeFormatter.ofPattern("dd'.'MM'.'yyyy").withLocale(Locale("ru", "RU"))
        val parseDate = LocalDate.of(date.year, date.month, date.dayOfMonth).format(formatter)
//        println("${date.dayOfMonth}-${date.monthValue}-${date.year}")
//        val d = LocalDate.parse("${date.dayOfMonth}-${date.monthValue}-${date.year}", formatter)
        return parseDate
    }
}
