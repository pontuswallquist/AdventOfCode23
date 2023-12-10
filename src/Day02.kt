import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var sumOfValidGames = 0
        for (line in input)
            sumOfValidGames += getValidGameNumber(line)
        return sumOfValidGames
    }

    fun part2(input: List<String>): Int {
        var sumOfPower = 0
        for (line in input)
            sumOfPower += getPowerOfSet(line)
        return sumOfPower
    }

    val input = readInput("Day02")
    val input2 = readInput("Day02")
    part1(input).println()
    part2(input2).println()
}

val maxValues = mapOf("red" to 12, "green" to 13, "blue" to 14)
fun getValidGameNumber(str: String): Int {

    val gameNr = str.substringBefore(":").substringAfter(" ").toInt()
    val sets = str.substringAfter(":").split(";")

    for (set in sets) {
        val gameMap = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)
        val subset = set.split(",")

        alterGameMap(subset, gameMap)

        if ( gameMap["red"]!! > maxValues["red"]!!
            || gameMap["blue"]!! > maxValues["blue"]!!
            || gameMap["green"]!! > maxValues["green"]!!)
            return 0
    }
    return gameNr
}
fun alterGameMap(subset: List<String>, gameMap: MutableMap<String, Int>) {
        for ( cube in subset) {
            val (countString, color) = cube.trim().split(" ")
            gameMap[color] = gameMap[color]!! + countString.toInt()
        }
}

fun getPowerOfSet(str: String): Int {
    val sets = str.substringAfter(":").split(";")

    var maxRed = 0
    var maxGreen = 0
    var maxBlue = 0

    for (set in sets) {
        val currentGameMap = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)
        val subset = set.split(",")

        alterGameMap(subset, currentGameMap)

        maxRed = max(currentGameMap["red"]!!, maxRed)
        maxGreen = max(currentGameMap["green"]!!, maxGreen)
        maxBlue = max(currentGameMap["blue"]!!, maxBlue)

    }
    return maxRed * maxGreen * maxBlue
}

