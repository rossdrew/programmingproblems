package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException

private val inputSampleA = """
RL

AAA = (BBB, CCC)
BBB = (DDD, EEE)
CCC = (ZZZ, GGG)
DDD = (DDD, DDD)
EEE = (EEE, EEE)
GGG = (GGG, GGG)
ZZZ = (ZZZ, ZZZ)
""".trimIndent()

private val inputSampleB = """
LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)
""".trimIndent()

private val inputSampleC = """
LR

11A = (11B, XXX)
11B = (XXX, 11Z)
11Z = (11B, XXX)
22A = (22B, XXX)
22B = (22C, 22C)
22C = (22Z, 22Z)
22Z = (22B, 22B)
XXX = (XXX, XXX)
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSampleA)}")
    //println("Sample Input A2: ${solutionA(inputSampleB)}")
    //println("Sample Input B: ${solutionB(inputSampleB)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day8.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day8.input"))}")
}

data class Step(val name: String, val left: String, val right: String)

fun toStep(name: String, entry: String): Step {
    val actions = entry.replace("(","").replace(")","").split(", ")
    return Step(name, actions[0], actions[1])
}

/**
 * Answer: 12737
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val instructions = rows[0]
    val maps = rows
        .slice(2 until rows.size)
        .map { r -> r.split(" = ") }
        .associate { r -> r[0] to toStep(r[0], r[1]) }

    var location = "AAA"
    var steps = 0
    val seq = generateSequence(0) { stepIndex -> (stepIndex + 1) % instructions.length }

    seq.forEach { instructionIndex ->
        val instruction = instructions[instructionIndex]
        location = move(location, instruction, maps)
        if (location == "ZZZ"){
            return ++steps
        }
        steps++
    }

    throw UnexpectedException("Should never get here, something is very wrong!")
}

/**
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    val instructions = rows[0]
    val maps = rows
        .slice(2 until rows.size)
        .map { r -> r.split(" = ") }
        .associate { r -> r[0] to toStep(r[0], r[1]) }

    var locations = maps.filter { map -> map.key.endsWith('A') }.map { entry -> entry.key }

    var steps = 0L
    val seq = generateSequence(0) { stepIndex -> (stepIndex + 1) % instructions.length }

    seq.forEach { instructionIndex ->
        locations = locations.map { loc -> move(loc, instructions[instructionIndex], maps) }
        if (locations.all { loc -> loc.endsWith('Z') }) {
            return ++steps
        }
        //XXX Somewhere in here it's too slow
        steps++
        //if (steps % 5000000 == 0L) println(steps)  5,000,000 in a second is too slow?!
        // Need to collapse repeated paths
    }

    throw UnexpectedException("Should never get here, something is very wrong!")
}

fun move(fromLocation: String, instruction: Char, maps: Map<String, Step>) : String {
    return if (instruction == 'R') maps[fromLocation]?.right.toString() else maps[fromLocation]?.left.toString()
}