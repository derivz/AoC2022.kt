fun main() {
    fun part1(lines: List<String>): Int {
        return lines.map { line ->
            val (left, right) = line.split(",")
            val (leftStart, leftEnd) = left.split("-").map { it.toInt() }
            val (rightStart, rightEnd) = right.split("-").map { it.toInt() }
            if ((leftStart <= rightStart && rightEnd <= leftEnd) || (rightStart <= leftStart && leftEnd <= rightEnd)) {
                1
            } else {
                0
            }
        }.sum()
    }

    fun part2(lines: List<String>): Int {
        return lines.map { line ->
            val (left, right) = line.split(",")
            val (leftStart, leftEnd) = left.split("-").map { it.toInt() }
            val (rightStart, rightEnd) = right.split("-").map { it.toInt() }
            if (
                (rightStart in leftStart..leftEnd)
                || (rightEnd in leftStart..leftEnd)
                || (leftStart in rightStart..rightEnd)
            ) {
                1
            } else {
                0
            }
        }.sum()
    }

    val lines = readLines("Day04")
    println(part1(lines))
    println(part2(lines))
}
