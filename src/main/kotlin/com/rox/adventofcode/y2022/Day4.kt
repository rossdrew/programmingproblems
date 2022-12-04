package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
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

    val matches = rows.map { row ->
        val pair = row.split(",")
        val elfA = pair[0].split("-").map { i -> i.toInt() }
        val elfB = pair[1].split("-").map { i -> i.toInt() }
        if (aContainsB(elfA,elfB) || aContainsB(elfB,elfA)) 1 else 0
    }

    return matches.sum()
}

fun aContainsB(a: List<Int>, b: List<Int>): Boolean{
    return a[0] <= b[0] && a[1] >= b[1]
}

/**
 *
 * Answer: 651 (too low)
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val matches = rows.map { row ->
        val pair = row.split(",")
        val elfA = pair[0].split("-").map { i -> i.toInt() }
        val elfB = pair[1].split("-").map { i -> i.toInt() }
        if (aOverlapsB(elfA,elfB) || aOverlapsB(elfB,elfA)) 1 else 0
    }

    return matches.sum()
}

fun aOverlapsB(a: List<Int>, b: List<Int>): Boolean {
    /**      A starts within Bs range */
    return (a[0] >= b[0] && a[0] <= b[1])
    /** OR   A ends within Bs range */
            || (a[1] >= b[0] && a[1] <= b[1])
}

