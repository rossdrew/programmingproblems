package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.max

private val inputSample = """
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day2.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day2.input"))}")
}

/**
 * Answer: 2265
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val availiable = mapOf("red" to 12, "green" to 13, "blue" to 14)
    var sum = 0;

    row@ for (row in rows){
        val (game, steps) = row.split(":")

        val gameNumber = game.substring(game.indexOf(" ")).trim().toInt()
        val groups = steps.split(";")

        group@ for (group in groups){
            val instructions = group.split(",")
            instruction@ for (instruction in instructions){
                val (number, color) = instruction.trim().split(" ")
                if (number.toInt() > (availiable[color] ?: 0)){
                    continue@row //Impossible game with given resources, skip it
                }
            }
        }

        sum += gameNumber
    }

    return sum
}

/**
 * Answer: 64097
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    var sum = 0;

    row@ for (row in rows){
        val (game, steps) = row.split(":")

        val groups = steps.split(";")

        val validSizes = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)

        group@ for (group in groups){
            val instructions = group.split(",")
            instruction@ for (instruction in instructions){
                val (number, color) = instruction.trim().split(" ")
                validSizes[color] = max((validSizes[color] ?: 0),number.toInt())
            }
        }

        sum += validSizes.values.reduce { acc, i ->  acc * i }
    }

    return sum
}

