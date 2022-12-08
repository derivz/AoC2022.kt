val rules = mapOf(
    "A" to mapOf("X" to 3, "Y" to 6, "Z" to 0),
    "B" to mapOf("X" to 0, "Y" to 3, "Z" to 6),
    "C" to mapOf("X" to 6, "Y" to 0, "Z" to 3),
)
val extraPoints = mapOf(
    "X" to 1, "Y" to 2, "Z" to 3
)
val desiredPoints = mapOf(
    "X" to 0, "Y" to 3, "Z" to 6
)
fun main() {
    fun part1(lines: List<String>): Int {
        return lines.map { line ->
            val (hisMove, myMove) = line.split(" ")
            val points = rules[hisMove]!![myMove]!! + extraPoints[myMove]!!
            points
        }.sum()
    }

    fun part2(lines: List<String>): Int {
        return lines.map { line ->
            val (hisMove, desiredOutput) = line.split(" ")
            val desiredPoints = desiredPoints[desiredOutput]!!
            val myMove = rules[hisMove]!!.filterValues { it == desiredPoints }.keys.first()
            val points = rules[hisMove]!![myMove]!! + extraPoints[myMove]!!
            points
        }.sum()
    }

    val lines = readLines("Day02")
    println(part1(lines))
    println(part2(lines))
}
