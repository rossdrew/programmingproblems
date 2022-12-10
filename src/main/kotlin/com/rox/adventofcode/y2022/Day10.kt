package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException

private val simpleSample = """
noop
addx 3
addx -5
""".trimIndent()

private val inputSample = """
addx 15
addx -11
addx 6
addx -3
addx 5
addx -1
addx -8
addx 13
addx 4
noop
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx -35
addx 1
addx 24
addx -19
addx 1
addx 16
addx -11
noop
noop
addx 21
addx -15
noop
noop
addx -3
addx 9
addx 1
addx -3
addx 8
addx 1
addx 5
noop
noop
noop
noop
noop
addx -36
noop
addx 1
addx 7
noop
noop
noop
addx 2
addx 6
noop
noop
noop
noop
noop
addx 1
noop
noop
addx 7
addx 1
noop
addx -13
addx 13
addx 7
noop
addx 1
addx -33
noop
noop
noop
addx 2
noop
noop
noop
addx 8
noop
addx -1
addx 2
addx 1
noop
addx 17
addx -9
addx 1
addx 1
addx -3
addx 11
noop
noop
addx 1
noop
addx 1
noop
noop
addx -13
addx -19
addx 1
addx 3
addx 26
addx -30
addx 12
addx -1
addx 3
addx 1
noop
noop
noop
addx -9
addx 18
addx 1
addx 2
noop
noop
addx 9
noop
noop
noop
addx -1
addx 2
addx -37
addx 1
addx 3
noop
addx 15
addx -21
addx 22
addx -6
addx 1
noop
addx 2
addx 1
noop
addx -10
noop
noop
addx 20
addx 1
addx 2
addx 2
addx -6
addx -11
noop
noop
noop
""".trimIndent()

fun main() {
    //println("(Simple) Sample Input A: ${solutionA(simpleSample)}")
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day10.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day10.input"))}")
}

/**
 *
 *
 * Answer: 17840
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val startState = Environment(1,1)
    var history = mutableListOf(startState)
    rows.map { row ->
        val parts = row.split(" ")

        when(parts[0]){
            OP.ADDX.token -> Pair(OP.ADDX, Integer.parseInt(parts[1]))
            OP.NOOP.token -> Pair(OP.NOOP, 0)
            else -> throw UnexpectedException("Operator '${parts[0]}' is unknown")
        }
    }.forEach { instruction ->
        val previousState = history.last()
        when (instruction.first){
            OP.ADDX -> {
                history.add(Environment(previousState.cycle+1, previousState.x))
                history.add(Environment(previousState.cycle+2, previousState.x+instruction.second))
            }
            OP.NOOP -> history.add(Environment(previousState.cycle+1, previousState.x))
        }

    }

    var sum = 0
    for (i in 19 until history.size step 40){
        val signalStrength = history[i].cycle * history[i].x
        sum+=signalStrength
        //println("${history[i]} -> $signalStrength")
    }

    return sum
}

/**
 *
 * Answer: EALGULPG
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val startState = Environment(1,1)
    var history = mutableListOf(startState)
    rows.map { row ->
        val parts = row.split(" ")

        when(parts[0]){
            OP.ADDX.token -> Pair(OP.ADDX, Integer.parseInt(parts[1]))
            OP.NOOP.token -> Pair(OP.NOOP, 0)
            else -> throw UnexpectedException("Operator '${parts[0]}' is unknown")
        }
    }.forEach { instruction ->
        val previousState = history.last()
        when (instruction.first){
            OP.ADDX -> {
                history.add(Environment(previousState.cycle+1, previousState.x))
                history.add(Environment(previousState.cycle+2, previousState.x+instruction.second))
            }
            OP.NOOP -> history.add(Environment(previousState.cycle+1, previousState.x))
        }

    }

    history.chunked(40).forEachIndexed { line, lineOfStates ->
        lineOfStates.forEachIndexed{pixel, state ->
            if (pixel in (state.x-1..state.x+1))
                print("#")
            else
                print(".")
        }
        print("\n")
    }

    return "^READ ABOVE^"
}

data class Environment(val cycle: Int, val x: Int)

enum class OP(val token: String,
              val cycles: Int) {
    ADDX("addx",2),
    NOOP("noop", 1)
}