package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        if (a.toUpperCase() == b) return "YES"
        else if (a != b) checkLine(a, b)
        val c = checkLine(a, b)
        println(c)
        if(c == b) return "YES"
        return "NO"
    }

    private fun checkLine(a: String, b: String):String {
        var newString = ""
        var lets = '\u0000'

        for (letterA in a) {
            lets = letterA
            for (letterB in b) {
                if (letterB.equals(lets, true)){
                    newString += "$letterB"
                }
            }
        }
        return newString
    }
}
