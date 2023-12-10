
val numbers = mapOf("one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9")

fun findLastNumber(str: String): String {
    return str.reversed().asSequence().find { it.isDigit() }.toString()
}
fun findFirstNumber(str: String): String {
    return str.asSequence().find { it.isDigit() }.toString()
}

fun addFirstDigit(str: String): String {
    var firstDigitIndex = str.indexOfFirst { it.isDigit() }

    if (firstDigitIndex == -1)
        firstDigitIndex = str.lastIndex

    var index = 0
    var newstring = ""
    
    while (index < firstDigitIndex) {
        val char = str[index].toString()
        newstring += char
        for (key in numbers.keys) {
            if (newstring.contains(key))
                return numbers[key] + str
        }
        index++
    }
    return str
}

fun addLastDigit(str: String): String {
    var lastDigitIndex = str.indexOfLast { it.isDigit() }

    if (lastDigitIndex == -1)
        lastDigitIndex = 0

    var index = str.lastIndex
    var newString = ""

    while (index > lastDigitIndex) {
        val char = str[index].toString()
        newString += char
        for (key in numbers.keys) {
            if (newString.reversed().contains(key))
                return str + numbers[key]
        }
        index--
    }
    return str
}

fun main() {
    fun part1(input: List<String>): Int {
        var lineSum = 0
        var lineValue: String
        for (str in input) {
            lineValue = findFirstNumber(str) + findLastNumber(str)
            lineSum += lineValue.toInt()
        }
        return lineSum
    }

    fun part2(input: List<String>): Int {
        var lineSum = 0
        var line: String
        for (str in input) {
            line = addFirstDigit(str)
            line = addLastDigit(line)
            line = findFirstNumber(line) + findLastNumber(line)
            lineSum += line.toInt()
        }
        return lineSum
    }

    val input = readInput("Day01")
    val input2 = readInput("Day1")
    part1(input).println()
    part2(input2).println()
}