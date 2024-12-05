package com.rox.adventofcode.y2024

import com.rox.adventofcode.GridCoord
import com.rox.adventofcode.TwoDGridDirection.*
import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day4.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day4.input"))}")
}

/**
 *
 *
 * Answer: 2599
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val grid = rows.map { line ->
        line.toCharArray().map { it.toString() }
    }

    var count = 0
    for (y in 0 until grid.size){
        for (x in 0 until grid[0].size){
            if (grid[y][x] == "X"){
                val location = GridCoord(grid, x, y)

                val occurrences = location.neighbours()
                    .filter { n -> n.cell.value() == "M" }
                    .map { p ->
                            location.vector(p.direction, 3, true).filter { c -> c.withinGrid() }
                    }
                    .filter { v -> v.map { c -> c.value() }.joinToString ("") == "XMAS" }
                //occurrences.forEach { o -> println("Found occurrence ('${o.map { c -> c.value() }.joinToString ("")}') at ${o.first().location} -> ${o.last().location}") }
                count += occurrences.count()
            }
        }
    }

    return count
}

/**
 *
 * Answer: 1948
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val grid = rows.map { line ->
        line.toCharArray().map { it.toString() }
    }

    var count = 0
    for (y in 0 until grid.size){
        for (x in 0 until grid[0].size){
            if (grid[y][x] == "A"){
                val location = GridCoord(grid, x, y)
                //Horizontals and verticals don't count, filter out any that dont start with 'M' while we're here
                val relevantNeighbours = location.neighbours().filter { n -> n.cell.value() == "M" && n.direction in setOf(NE, SE, SW, NW) }

                if (relevantNeighbours.count() > 1){
                    val validIntersections = relevantNeighbours
                        //List of neighbours intersecting this one which are within the grid
                        .map { n -> n.cell.vector(n.direction.inverse(), 2, true).filter { c -> c.withinGrid() } }
                        //Those which spell out MAS
                        .filter { v -> v.map { c -> c.value() }.joinToString ("") == "MAS" }

                    if (validIntersections.count() > 1) count++
                }
            }
        }
    }

    return count
}

