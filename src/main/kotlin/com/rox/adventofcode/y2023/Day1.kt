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

private val inputSampleC = """
1sevenine 
2oneight
3nineight
4eightwo
5eighthree
6threeight
7fiveight
8twone
""".trimIndent() //19, 28, 38, 42, 53, 68, 78, 81 = 407

fun main() {
  //  println("Sample Input A: ${solutionA(inputSampleA)}")
  //  println("Sample Input B: ${solutionB(inputSampleB)}")
  //  println("Sample Input B: ${solutionB(inputSampleB)}")
  //  println("Sample Input B 2: ${solutionB(inputSampleC)} should be 407")
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

private val digitRegex = "[0-9]".toRegex()
private val numberRegex = "one|two|three|four|five|six|seven|eight|nine|[0-9]".toRegex()

/**
 *
 * Answer: 54807 (TOO LOW)
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return rows
        .map { row -> convertFirstAndLastWordsToNumbers(row) }
        .map { row ->
            row.substring(
                row.indexOfFirst { c -> c.isDigit() },
                row.indexOfLast { c -> c.isDigit() } + 1)
        }
        .map { middle -> "${middle[0]}${middle[middle.length-1]}".toInt() }
        .sum()
}

private fun convertFirstAndLastWordsToNumbers(line : String): String {
    val first = "(one|two|three|four|five|six|seven|eight|nine|\\d)".toRegex().findAll(line).first().value
    val last = "(${"one|two|three|four|five|six|seven|eight|nine".reversed()}|\\d)".toRegex().findAll(line.reversed()).first().value.reversed()

    return "${convertWordToDigit(first)}${convertWordToDigit(last)}";
}

private fun convertAllWordsToNumbers(line: String) : String{
    val regex = "(one|two|three|four|five|six|seven|eight|nine)".toRegex()

    val endSize = if (line.length < 5) line.length else line.length - 5
    val replaceLastFiveCharactersFirst = regex.replace(line.substring(endSize)) { m -> convertWordToDigit(m.value)}
    val andStickItBackOnToMakeModifiedLine = line.substring(0, endSize) + replaceLastFiveCharactersFirst

    regex.findAll(line).last()

    return regex.replace(andStickItBackOnToMakeModifiedLine) {
        m -> convertWordToDigit(m.value)
    }
}

private fun convertWordToDigit(word: String): String {
    if (word.toIntOrNull() != null) return word

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