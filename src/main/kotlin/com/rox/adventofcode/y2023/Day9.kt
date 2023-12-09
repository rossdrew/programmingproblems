package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
0 3 6 9 12 15
1 3 6 10 15 21
10 13 16 21 30 45
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day9.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day9.input"))}")
}

/**
 * Answer: 1731106378
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    var sum = 0
    for (row in rows) {
        val rowSequence = row.split(" ").map { e -> e.trim().toInt() }

        var sequences = mutableListOf(rowSequence)
        var deltaSequence = nextSequence(rowSequence)
        while (deltaSequence.any { e -> e != 0 }){
            sequences.add(deltaSequence)
            deltaSequence = nextSequence(deltaSequence)
        }
        //sequences.add(deltaSequence) - it's always zero so would never be usefully added

        for (ri in sequences.size-2 downTo 0){
            val lastNumberInSequence = sequences[ri][sequences[ri].size-1]
            val newEntry = lastNumberInSequence + sequences[ri+1][sequences[ri+1].size-1]
            val newSequence = mutableListOf<Int>()
            newSequence.addAll(sequences[ri])
            newSequence.add(newEntry)
            sequences[ri] = newSequence
        }

        sum += sequences[0][sequences[0].size-1]
    }

    return sum
}

fun nextSequence(inputSequence: List<Int>): List<Int> = (1 until inputSequence.size).map { i -> inputSequence[i] - inputSequence[i-1] }

/**
 * Answer: 1087
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    var sum = 0
    for (row in rows) {
        val rowSequence = row.split(" ").map { e -> e.trim().toInt() }

        var sequences = mutableListOf(rowSequence)
        var deltaSequence = nextSequence(rowSequence)
        while (deltaSequence.any { e -> e != 0 }){
            sequences.add(deltaSequence)
            deltaSequence = nextSequence(deltaSequence)
        }
        //sequences.add(deltaSequence) - it's always zero so would never be usefully added

        for (ri in sequences.size-2 downTo 0){
            val firstNumberInSequence = sequences[ri][0]
            val newEntry = firstNumberInSequence - sequences[ri+1][0]
            val newSequence = mutableListOf<Int>()
            newSequence.add(newEntry)
            newSequence.addAll(sequences[ri])
            sequences[ri] = newSequence
        }

        sum += sequences[0][0]
    }

    return sum
}