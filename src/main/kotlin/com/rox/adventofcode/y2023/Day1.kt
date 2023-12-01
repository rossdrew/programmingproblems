package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile
import java.lang.RuntimeException

private val inputSampleA = """
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
""".trimIndent()

private val inputSampleB = """
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
""".trimIndent()

fun main() {
  //  println("Sample Input A: ${solutionA(inputSampleA)}")
    println("Sample Input B: ${solutionB(inputSampleB)}")
  //  println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day1.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day1.input"))}")
}

/**
 *
 *
 * Answer: 55386
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    return rows
        .map { row ->
            row.substring(
                row.indexOfFirst { c -> c.isDigit() },
                row.indexOfLast { c -> c.isDigit() } + 1)
        }
        .map { middle -> "${middle[0]}${middle[middle.length-1]}".toInt() }
        .sum()
}

/**
 *
 * Answer: 54807 (TOO LOW)
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val g = rows.map { row -> convertAllWordsToNumbers(row) }

    return rows
        .map { row -> convertAllWordsToNumbers(row) }
        .map { row ->
            row.substring(
                row.indexOfFirst { c -> c.isDigit() },
                row.indexOfLast { c -> c.isDigit() } + 1)
        }
        .map { middle -> "${middle[0]}${middle[middle.length-1]}".toInt() }
        .sum()
}

private fun convertAllWordsToNumbers(line: String) : String{
    val regex = "(one|two|three|four|five|six|seven|eight|nine)".toRegex()

    val endSize = if (line.length < 5) line.length else line.length - 5
    val replaceLastFiveCharactersFirst = regex.replace(line.substring(endSize)) { m -> convertWordToDigit(m.value)}
    val andStickItBackOnToMakeModifiedLine = line.substring(0, endSize) + replaceLastFiveCharactersFirst

    //XXX This is probably doing the first one right but eager replacement is ruining the last number
    return regex.replace(andStickItBackOnToMakeModifiedLine) {
        m -> convertWordToDigit(m.value)
    }
}

private fun convertWordToDigit(word: String): String {
    return when (word){
        "one" -> "1"
        "two" -> "2"
        "three" -> "3"
        "four" -> "4"
        "five" -> "5"
        "six" -> "6"
        "seven" -> "7"
        "eight" -> "8"
        "nine" -> "9"
        else -> throw RuntimeException("Unknown \"number\" '${word}'")
    }
}