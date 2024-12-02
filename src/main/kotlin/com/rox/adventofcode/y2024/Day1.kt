package com.rox.adventofcode.y2024

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.abs
import kotlin.math.floor

private val inputSample = """
3   4
4   3
2   5
1   3
3   9
3   3
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day1.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day1.input"))}")
}

/**
 *
 * Answer: 1603498
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val pairs = rows.map { row -> row.trim().split("\\s+".toRegex()) }
    val left = pairs.map { it[0].toInt() }.sorted()
    val right = pairs.map { it[1].toInt() }.sorted()
    val sortedRows = left zip right

    val differences = sortedRows.map { row -> abs(row.first - row.second) }

    return differences.sum()
}

/**
 *
 * Answer: 25574739
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    val pairs = rows.map { row -> row.trim().split("\\s+".toRegex()) }
    val left = pairs.map { it[0].toInt() }.sorted()
    val right = pairs.map { it[1].toInt() }.sorted()

    val similarityScore = left.map { n -> right.count{it == n} * n }

    return similarityScore.sum()
}

