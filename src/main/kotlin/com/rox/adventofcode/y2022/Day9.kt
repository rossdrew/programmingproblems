package com.rox.adventofcode.y2022

import com.rox.adventofcode.CardinalDirection
import com.rox.adventofcode.CardinalDirection.*
import com.rox.adventofcode.SimpleCoord
import com.rox.adventofcode.puzzleInputFromFile
import org.junit.jupiter.api.assertAll
import java.rmi.UnexpectedException
import kotlin.math.abs

private val inputSample = """
R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2
""".trimIndent()

private val alternateInputSample = """
R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(alternateInputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day9.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day9.input"))}")
}

/**
 *
 *
 * Answer: 6522
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    var head = SimpleCoord(100,100)
    var tail = SimpleCoord(100,100)
    val tailVisited = mutableSetOf(tail)

    rows.forEach { row ->
        val parts = row.split(" ").zipWithNext().first()
        val direction = cardinalFromLRUD(parts.first)
        val steps = Integer.parseInt(parts.second)
        for (step in 0 until steps){
            head = direction.directionTransform(head)

            //Supplemental (diagonal) move if we are not touching and not in the same column or row
            if (abs(tail.x-head.x) + abs(tail.y-head.y) == 3){
                when (tail.x-head.x){
                    -1 -> tail = EAST.directionTransform(tail)
                    1 -> tail = WEST.directionTransform(tail)
                }
                when (tail.y-head.y){
                    -1 -> tail = SOUTH.directionTransform(tail)
                    1 -> tail = NORTH.directionTransform(tail)
                }
            }

            when (tail.x - head.x){
                -2 -> tail = EAST.directionTransform(tail)
                2 -> tail = WEST.directionTransform(tail)
            }

            when (tail.y - head.y){
                -2 -> tail = SOUTH.directionTransform(tail)
                2 -> tail = NORTH.directionTransform(tail)
            }

            tailVisited.add(tail)
        }
    }

    return tailVisited.size
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val rope = Array(10) {SimpleCoord(100,100)}
    val tailVisited = mutableSetOf(rope[9])

    rows.forEach { row ->
        val parts = row.split(" ").zipWithNext().first()
        val direction = cardinalFromLRUD(parts.first)
        val steps = Integer.parseInt(parts.second)
        for (step in 0 until steps){
            rope[0] = direction.directionTransform(rope[0])
            for (ropeSegment in 1 until 10){
                //Supplemental (diagonal) move if we are not touching and not in the same column or row
                if (abs(rope[ropeSegment].x-rope[ropeSegment-1].x) + abs(rope[ropeSegment].y-rope[ropeSegment-1].y) == 3){
                    when (rope[ropeSegment].x-rope[ropeSegment-1].x){
                        -1 -> rope[ropeSegment] = EAST.directionTransform(rope[ropeSegment])
                        1 -> rope[ropeSegment] = WEST.directionTransform(rope[ropeSegment])
                    }
                    when (rope[ropeSegment].y-rope[ropeSegment-1].y){
                        -1 -> rope[ropeSegment] = SOUTH.directionTransform(rope[ropeSegment])
                        1 -> rope[ropeSegment] = NORTH.directionTransform(rope[ropeSegment])
                    }
                }

                when (rope[ropeSegment].x - rope[ropeSegment-1].x){
                    -2 -> rope[ropeSegment] = EAST.directionTransform(rope[ropeSegment])
                    2 -> rope[ropeSegment] = WEST.directionTransform(rope[ropeSegment])
                }

                when (rope[ropeSegment].y - rope[ropeSegment-1].y){
                    -2 -> rope[ropeSegment] = SOUTH.directionTransform(rope[ropeSegment])
                    2 -> rope[ropeSegment] = NORTH.directionTransform(rope[ropeSegment])
                }
            }

            tailVisited.add(rope[9])
        }
    }

    return tailVisited.size
}


fun cardinalFromLRUD(c: String): CardinalDirection {
    return when (c){
        "U" -> NORTH
        "D" -> SOUTH
        "L" -> WEST
        "R" -> EAST
        else -> throw UnexpectedException("Direction $c is unknown")
    }
}

