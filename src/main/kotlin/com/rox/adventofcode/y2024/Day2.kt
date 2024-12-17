package com.rox.adventofcode.y2024

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.abs

private val inputSample = """
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day2.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day2.input"))}")
}

enum class State {
    INC,DEC,UNKNOWN
}

/**
 * Answer: 202
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val columnSeperatedRows = rows.map { row -> row.split(' ') }

    return columnSeperatedRows.map { row -> rowSafe(row) }.count { it }
}

/**
 * Answer: 268 (TOO LOW)
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    val columnSeperatedRows = rows.map { row -> row.split(' ') }

    return columnSeperatedRows.map { row -> rowSafe(row, 1) }.count { it }
}

private fun rowSafe(row: List<String>, tolerance: Int = 0, indent: String = ""): Boolean {
    var expectedState = State.UNKNOWN
    for (column in 1 until row.size){
        val current = row[column].toInt()
        val previous = row[column - 1].toInt()

        //UNSAFE: Difference is not 1-3
        if (previous == current || abs(current - previous) > 3) {
            println("${indent}UNSAFE (high step @ $column): $row, difference was ${current-previous} between $current & $previous")
            return toleranceCheck(tolerance, row, column)
        }

        val currentState = if (current > previous) State.INC else State.DEC

        if (expectedState == State.UNKNOWN) {
            expectedState = currentState
        } else if (expectedState != currentState) {
            //UNSAFE: Switched between increasing and decreasing
            println("${indent}UNSAFE (switched direction @ $column): ${row}. ($previous -> $current), $currentState when expecting $expectedState")
            return toleranceCheck(tolerance, row, column)
        }
    }
    println("${indent}SAFE: $row")
    return true
}

private fun toleranceCheck(tolerance: Int, row: List<String>, column: Int): Boolean {
    return if (tolerance == 1) {
        val a = row.filterIndexed { i, _ -> i != column }
        val b = row.filterIndexed { i, _ -> i != column - 1 }
        println("\tTrying with $a & $b")

        rowSafe(b,0, "\t\t") || rowSafe(a,0, "\t\t")
    } else {
        false
    }
}
