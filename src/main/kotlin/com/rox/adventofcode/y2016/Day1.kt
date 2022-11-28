package com.rox.adventofcode.y2016

import com.rox.adventofcode.*
import com.rox.adventofcode.CardinalDirection.*

//Answer 5
private val inputSampleA = """
R2, L3
""".trimIndent()

//Answer 12
private val inputSampleB = """ 
R5, L5, R5, R3
""".trimIndent()

//Answer 2
private val inputSampleC = """
R2, R2, R2
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSampleA)}")
    //println("Sample Input B: ${solutionA(inputSampleB)}")
    //println("Sample Input C: ${solutionA(inputSampleC)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2016/day1.input"))}")
    //println("Part B: ${com.rox.adventofcode.y2021.solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/day1.input"))}")
}

/**
 * --- Day 1: No Time for a Taxicab ---
 * Santa's sleigh uses a very high-precision clock to guide its movements, and the clock's oscillator is regulated by
 * stars. Unfortunately, the stars have been stolen... by the Easter Bunny. To save Christmas, Santa needs you to
 * retrieve all fifty stars by December 25th.
 *
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second
 * puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 *
 * You're airdropped near Easter Bunny Headquarters in a city somewhere. "Near", unfortunately, is as close as you can
 * get - the instructions on the Easter Bunny Recruiting Document the Elves intercepted start here, and nobody had time
 * to work them out further.
 *
 * The Document indicates that you should start at the given coordinates (where you just landed) and face North. Then,
 * follow the provided sequence: either turn left (L) or right (R) 90 degrees, then walk forward the given number of
 * blocks, ending at a new intersection.
 *
 * There's no time to follow such ridiculous instructions on foot, though, so you take a moment and work out the
 * destination. Given that you can only walk on the street grid of the city, how far is the shortest path to the
 * destination?
 *
 * For example:
 *
 * Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away.
 * R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away.
 * R5, L5, R5, R3 leaves you 12 blocks away.
 * How many blocks away is Easter Bunny HQ?
 *
 * Answer: ???
 * Incorrect: 73
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val directions = rows[0].split(", ")
    val startState = DirectionalCoord(SimpleCoord(0, 0), NORTH)
    //println("${directions.size} steps...")

    val finalState = directions.fold(startState, { state, nextDirection ->
        val steps = Integer.parseInt(nextDirection.substring(1))
        //println("\t @ (${state.location.x},${state.location.y}) facing ${state.direction}. ($nextDirection) Turning ${parseDirection(nextDirection[0], state.direction)} for $steps...")

        when (parseDirection(nextDirection[0], state.direction)) {
            NORTH -> DirectionalCoord(SimpleCoord(state.location.x, state.location.y - steps), NORTH)
            SOUTH -> DirectionalCoord(SimpleCoord(state.location.x, state.location.y + steps), SOUTH)
            EAST -> DirectionalCoord(SimpleCoord(state.location.x + steps, state.location.y), EAST)
            WEST -> DirectionalCoord(SimpleCoord(state.location.x - steps, state.location.y), WEST)
        }
    })

    //println("\t Ended @ (${finalState.location.x},${finalState.location.y}) facing ${finalState.direction}. Distance = ${manhattanDistance(startState.location, finalState.location)}")
    return manhattanDistance(startState.location, finalState.location)
}

private fun parseDirection(value: Char, direction: CardinalDirection) : CardinalDirection {
    return when (direction){
        //XXX rogue input will count as 'R'
        NORTH -> if (value == 'L') WEST else EAST
        SOUTH -> if (value == 'L') EAST else WEST
        WEST -> if (value == 'L') SOUTH else NORTH
        EAST -> if (value == 'L') NORTH else SOUTH
    }
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

