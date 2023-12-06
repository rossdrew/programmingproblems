package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
Time:      7  15   30
Distance:  9  40  200
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day6.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day6.input"))}")
}

/**
 * Answer: 2269432
 */
private fun solutionA(input: String): Any {
    val (timeRow, distanceRow) = input.split('\n').map { s -> s.substring(s.indexOf(":") + 1).trim().replace("\\s+".toRegex(), " ") }
    val races = timeRow.split(" ").map { t -> t.toInt() }.zip(distanceRow.split(" ").map { d -> d.toInt() })

    val product = races.map { (time, recordDistance) ->
        (1 until time).map { speedTime ->
            val movingTime = time - speedTime
            val distanceTravelled = movingTime * speedTime

            if (distanceTravelled > recordDistance) 1 else 0
        }.sum()
    }.reduce { a, hold -> a * hold }

    return product
}

/**
 * Answer: 35865985
 */
private fun solutionB(input: String): Any {
    val (time, recordDistance) = input.split('\n').map { s -> s.substring(s.indexOf(":") + 1).trim().replace("\\s+".toRegex(), "").toLong() }

    return (1 until time).map { speedTime ->
        val movingTime = time - speedTime
        val distanceTravelled = movingTime * speedTime

        if (distanceTravelled > recordDistance) 1 else 0
    }.sum()
}