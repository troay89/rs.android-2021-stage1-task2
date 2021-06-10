package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val checkMonth = checkMonth(month)
        val formatter = DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy").withLocale(Locale("ru", "RU"))
        var date = ""
        date = try {
            val parseDate = LocalDate.parse("$day-$checkMonth-$year", formatter)
            val dayOfWeek = translateDayOfWeek(parseDate.dayOfWeek.toString())
            val months = translateMonth(parseDate.monthValue)
            if(parseDate.dayOfMonth < day.toInt()) "Такого дня не существует"
            else "${parseDate.dayOfMonth} $months, $dayOfWeek"
        }catch (e: DateTimeParseException){
            "Такого дня не существует"
        }
        return date
    }

    private fun checkMonth(month: String): String {
        var result = month
        if (month.toInt() < 10){
            result = "0$result"
            println(result)
        }
        return result
    }

    private fun translateMonth(index: Int) = when (index) {
        1 -> "января"
        2 -> "февраля"
        3 -> "марта"
        4 -> "апреля"
        5 -> "мая"
        6 -> "июня"
        7 -> "июля"
        8 -> "августа"
        9 -> "сентября"
        10 -> "октября"
        11 -> "ноября"
        else -> "декабря"
    }

    private fun translateDayOfWeek(index: String) = when (index.toLowerCase()) {
        "monday" -> "понедельник"
        "tuesday"-> "вторник"
        "wednesday" -> "среда"
        "thursday" -> "четверг"
        "friday" -> "пятница"
        "saturday" -> "суббота"
        else -> "воскресенье"
    }
}
