import java.util.ArrayDeque

fun main() {
    fun getState(lines: String): Map<Int, ArrayDeque<Char>> {
        val state = mutableMapOf<Int, ArrayDeque<Char>>()
        val rules = lines.split("\n\n")[0].split("\n").reversed()
        val size = rules[0].length
        rules.map { it.padEnd(size) }.map { it.toCharArray().toList() }.transpose().filter { it[0].isDigit() }.map { it.filter { it != ' ' } }.map {
            val key = it[0].toString().toInt()
            val value = it.drop(1).toMutableList()
            state[key] = value.reversed().toCollection(ArrayDeque())
        }
        return state.toMap()
    }

    fun getMove(line: String): List<Int> {
        return Regex("(\\d+)").findAll(line).map { it.value.toInt() }.toList().slice(0..2)
    }

    fun part1(rules: String, lines: String): String {
        val state = getState(rules)
        lines.split('\n').forEach { line ->
            val (num, from, to) = getMove(line)
            repeat(num) {
                val value = state[from]!!.pop()
                state[to]!!.push(value)
            }

        }
        return state.map { it.value.first }.joinToString("")
    }

    fun part2(rules: String, lines: String): String {
        val state = getState(rules)
        lines.split('\n').forEach { line ->
            val (num, from, to) = getMove(line)
            val values = mutableListOf<Char>()
            repeat(num) { values.add(state[from]!!.pop()) }
            values.reversed().forEach { state[to]!!.push(it) }
        }
        return state.map { it.value.first }.joinToString("")
    }

    val input = readInput("Day05")
    val (rules, moves) = input.split("\n\n").slice(0..1)

    println(part1(rules, moves))
    println(part2(rules, moves))
}
