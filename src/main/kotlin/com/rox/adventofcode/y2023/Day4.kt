package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile

typealias Line = Pair<List<String>,List<String>>

private val inputSample = """
Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day4.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day4.input"))}")
}

/**
 *
 *
 * Answer: 28750
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    return rows.map {
        row -> row
            .split(":")[1]
            .trim() }
        .map {
            parts -> parts
                .split("|")
        }.map { pair ->
            val winningNumbers = pair[0].replace("  "," ").trim().split(" ")
            val numbersIHave = pair[1].replace("  "," ").trim().split(" ")
            val winners = winningNumbers.count { n -> numbersIHave.contains(n) }

            var result = if (winners > 0 ) 1 else 0
            for (i in 1 until winners){
                result *= 2
            }
            result
        }.sum()
}

/**
 * Answer: 10212704
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    val lines = rows.map {
            row -> row
        .split(":")[1]
        .trim() }
        .map {
                parts -> parts
            .split("|")
        }.map { pair ->
            val winningNumbers = pair[0].replace("  "," ").trim().split(" ")
            val numbersIHave = pair[1].replace("  "," ").trim().split(" ")
            Pair(winningNumbers, numbersIHave)
        }

    val duplicates = MutableList(lines.size) { 1 }

    for (i in lines.indices){
        var winners = lines[i].first.count { n -> lines[i].second.contains(n) }

        for (duplicateCreationIndex in i+1 .. i+winners){
            if (duplicateCreationIndex >= lines.size) break
            duplicates[duplicateCreationIndex] = duplicates[duplicateCreationIndex]+duplicates[i]
        }
    }
    return duplicates.sum()
}
