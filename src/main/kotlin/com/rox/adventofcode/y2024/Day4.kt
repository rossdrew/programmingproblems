package com.rox.adventofcode.y2024

import com.rox.adventofcode.GridCoord
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

/*
  0123456789
0 ....XXMAS. (4,0)->(7,3), (5,0)->(8,0)
1 .SAMXMS... (4,1)->(1,1)
2 ...S..A...
3 ..A.A.MS.X (9,3)->(9,6), (9,3)->(6,6)
4 XMASAMX.MM (0,4)->(3,4), (6,4)->(6,1), (6,4)->(3,4)
5 X.....XA.A (0,5)->(3,2), (6,5)->(3,2)
6 S.S.S.S.SS
7 .A.A.A.A.A
8 ..M.M.M.MM
9 .X.X.XMASX **(1,9)->(4,5)**, (3,9)->(6,6), (3,9)->(0,6), (5,9)->(8,6), (5,9)->(8,9), (5,9)->(2,6), (9,9)->(9,6), (9,9)->(6,6)
 */

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day4.input"))}")
    //println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
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
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

