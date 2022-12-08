fun main() {
    val input = readInput("Day01")
    val gr = input.split("\n\n").map { it.split("\n").map { it.toIntOrNull() ?: 0 } }.map { it.sum() }

    fun part1(gr: List<Int>): Int {
        return gr.max()
    }

    fun part2(gr: List<Int>): Int {
        return gr.sorted().takeLast(3).sum()
    }

    println(part1(gr))
    println(part2(gr))
}
