// create map of all lowercase letters and uppercase letters to numbers from 1 to 52
val letterValues = ('a'..'z').zip(1..26).toMap() + ('A'..'Z').zip(27..52).toMap()

fun main() {
    fun part1(lines: List<String>): Int {
        return lines.map { line ->
            val left = line.substring(0, line.length / 2).toSet()
            val right = line.substring(line.length / 2).toSet()
            val commonLetters = left.intersect(right)
            letterValues[commonLetters.first()]!!
        }.sum()
    }

    fun part2(lines: List<String>): Int {
        // group line by chunks of 3
        return lines.chunked(3).map {
            val commonLetters = it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet())
            letterValues[commonLetters.first()]!!
        }.sum()
    }

    val lines = readLines("Day03")
    println(part1(lines))
    println(part2(lines))
}
