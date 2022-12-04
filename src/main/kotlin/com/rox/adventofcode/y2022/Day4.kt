package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.max
import kotlin.math.min

private val inputSample = """
2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day4.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day4.input"))}")
}

/**
 *
 *
 * Answer: 651
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    return extractData(rows)
        .filter { elfs -> aContainsB(elfs.first, elfs.second) || aContainsB(elfs.second, elfs.first) }
        .count()
}

fun aContainsB(a: List<Int>, b: List<Int>): Boolean {
    return a[0] <= b[0] && a[1] >= b[1]
}

/**
 *
 * Answer: 956
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    return extractData(rows)
        .filter { elfs -> thereExistsOverlap(elfs.first, elfs.second) }
        .count()
}

fun thereExistsOverlap(a: List<Int>, b: List<Int>): Boolean {
    return max(a[0],b[0]) <= min(a[1],b[1])
}

/** A range of sections assigned to an elf */
typealias elfRange = List<Int>
/** A work pair of elfs sections */
typealias elfPair = Pair<elfRange,elfRange>

/**
 * Extract out a List of elfPairs made up of two elfRanges
 */
fun extractData(rows: List<String>): List<elfPair> {
    return rows.map { row ->
        val pair = row.split(",")
        val elfA = pair[0].split("-").map { i -> i.toInt() }
        val elfB = pair[1].split("-").map { i -> i.toInt() }
        Pair(elfA,elfB)
    }
}

