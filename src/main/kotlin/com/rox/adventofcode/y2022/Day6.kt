package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException

private val inputSample = """
mjqjpqmgbljsphdztnvjfqwrcgsmlb
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day6.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day6.input"))}")
}

/**
 *
 *
 * Answer: 1282
 */
private fun solutionA(input: String): Any {
    val packetSize = 4
    for (i in 0 until input.length - packetSize){
        if (input.subSequence(i, i + packetSize).chars().distinct().count().toInt() == packetSize) {
            return i+4
        }
    }

    throw UnexpectedException("Input doesn't contain 4 consecutive distinct chracters")
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val packetSize = 14
    for (i in 0 until input.length - packetSize){
        if (input.subSequence(i, i + packetSize).chars().distinct().count().toInt() == packetSize) {
            return i+packetSize
        }
    }

    throw UnexpectedException("Input doesn't contain 4 consecutive distinct chracters")
}

