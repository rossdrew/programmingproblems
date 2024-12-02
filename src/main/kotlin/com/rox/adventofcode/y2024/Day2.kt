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
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day2.input"))}")
    //println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
}

enum class State {
    INC,DEC,UNKNOWN
}

/**
 *
 *
 * Answer: 202
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val columnSeperatedRows = rows.map { row -> row.split(' ') }

    return safeRows(columnSeperatedRows)
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    val columnSeperatedRows = rows.map { row -> row.split(' ') }

    return "TODO"
}

private fun safeRows(columnSeperatedRows: List<List<String>>): Int {
    var safeRows = 0

    row@ for (row in columnSeperatedRows.indices) {
        var expectedState = State.UNKNOWN
        for (column in 1 until columnSeperatedRows[row].size) {
            val current = columnSeperatedRows[row][column].toInt()
            val previous = columnSeperatedRows[row][column - 1].toInt()

            //UNSAFE: Difference is not 1-3
            if (previous == current || abs(current - previous) > 3) {
                //println("UNSAFE (1): ${columnSeperatedRows[row]}")
                continue@row
            }

            val currentState = if (current > previous) State.INC else State.DEC

            if (expectedState == State.UNKNOWN) {
                expectedState = currentState
            } else if (expectedState != currentState) {
                //UNSAFE: Switched between increasing and decreasing
                //println("UNSAFE (2): ${columnSeperatedRows[row]}. ($current -> $previous), ${currentState} when expecting ${expectedState}")
                continue@row
            }
        }
        //println("SAFE: ${columnSeperatedRows[row]}")
        safeRows++
    }

    return safeRows
}
