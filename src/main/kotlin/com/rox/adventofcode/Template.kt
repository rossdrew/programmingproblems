package com.rox.adventofcode

import java.io.File

private val inputSample = """
""".trimIndent()

fun puzzleInputFromFile(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

fun main() {
    println("Sample Input: ${solutionA(inputSample)}")
    //println("Part A: ${solutionA(inputA)}")
    //println("Part B: ${solutionB(inputA)}")
}

/**
 *
 *
 * Answer: ???
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    return input
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

