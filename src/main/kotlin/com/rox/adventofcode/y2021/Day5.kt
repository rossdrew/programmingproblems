package com.rox.adventofcode.y2021

import com.rox.adventofcode.puzzleInputFromFile
import java.lang.RuntimeException
import kotlin.math.abs

private val inputSample = """
0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day5.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day5.input"))}")
}

/**
 * --- Day 5: Hydrothermal Venture ---
 * You come across a field of hydrothermal vents on the ocean floor! These vents constantly produce large, opaque
 * clouds, so it would be best to avoid them if possible.
 *
 * They tend to form in lines; the submarine helpfully produces a list of nearby lines of vents (your puzzle input)
 * for you to review. For example:
 *
 * 0,9 -> 5,9
 * 8,0 -> 0,8
 * 9,4 -> 3,4
 * 2,2 -> 2,1
 * 7,0 -> 7,4
 * 6,4 -> 2,0
 * 0,9 -> 2,9
 * 3,4 -> 1,4
 * 0,0 -> 8,8
 * 5,5 -> 8,2
 * Each line of vents is given as a line segment in the format x1,y1 -> x2,y2 where x1,y1 are the coordinates of one
 * end the line segment and x2,y2 are the coordinates of the other end. These line segments include the points at
 * both ends. In other words:
 *
 * An entry like 1,1 -> 1,3 covers points 1,1, 1,2, and 1,3.
 * An entry like 9,7 -> 7,7 covers points 9,7, 8,7, and 7,7.
 * For now, only consider horizontal and vertical lines: lines where either x1 = x2 or y1 = y2.
 *
 * So, the horizontal and vertical lines from the above list would produce the following diagram:
 *
 * .......1..
 * ..1....1..
 * ..1....1..
 * .......1..
 * .112111211
 * ..........
 * ..........
 * ..........
 * ..........
 * 222111....
 *
 * In this diagram, the top left corner is 0,0 and the bottom right corner is 9,9. Each position is shown as the
 * number of lines which cover that point or . if no line covers that point. The top-left pair of 1s, for example,
 * comes from 2,2 -> 2,1; the very bottom row is formed by the overlapping lines 0,9 -> 5,9 and 0,9 -> 2,9.
 *
 * To avoid the most dangerous areas, you need to determine the number of points where at least two lines overlap.
 * In the above example, this is anywhere in the diagram with a 2 or larger - a total of 5 points.
 *
 * Consider only horizontal and vertical lines. At how many points do at least two lines overlap?g\
 *
 * Answer: 8111
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    var grid = mutableMapOf<Coord, Int>()

    rows.map { r ->
        val statement = r.split(" -> ")

        val lhs = statement[0].split(",")
        val rhs = statement[1].split(",")

        val start = Coord(lhs[0].toInt(), lhs[1].toInt())
        val end = Coord(rhs[0].toInt(), rhs[1].toInt())

        //Pairs of Coords
        Pair(start, end)
    }.filter { p ->
        //Only the vertical and horizontal lines
        p.first.x == p.second.x || p.first.y == p.second.y
    }.map { p ->
        //Put in ascending order
        if (p.second.x < p.first.x || p.second.y < p.first.y)
            Pair(p.second, p.first)
        else
            p
    }.map { p ->
        //Build grid
        val a = p.first
        val b = p.second

        for (x in a.x .. b.x ){
            for (y in a.y .. b.y ){
                val currentCoord = Coord(x,y)
                val oldValue = grid.getOrDefault(currentCoord, 0)
                grid[currentCoord] = oldValue+1
            }
        }
    }

    return grid.filter { e ->
        e.value > 1
    }.count()
}

data class Coord(val x: Int, val y: Int)

/**
 *
 * --- Part Two ---
 * Unfortunately, considering only horizontal and vertical lines doesn't give you the full picture; you need to also
 * consider diagonal lines.
 *
 * Because of the limits of the hydrothermal vent mapping system, the lines in your list will only ever be horizontal,
 * vertical, or a diagonal line at exactly 45 degrees. In other words:
 *
 * An entry like 1,1 -> 3,3 covers points 1,1, 2,2, and 3,3.
 * An entry like 9,7 -> 7,9 covers points 9,7, 8,8, and 7,9.
 * Considering all lines from the above example would now produce the following diagram:
 *
 * 1.1....11.
 * .111...2..
 * ..2.1.111.
 * ...1.2.2..
 * .112313211
 * ...1.2....
 * ..1...1...
 * .1.....1..
 * 1.......1.
 * 222111....
 * You still need to determine the number of points where at least two lines overlap. In the above example, this is
 * still anywhere in the diagram with a 2 or larger - now a total of 12 points.
 *
 * Consider all of the lines. At how many points do at least two lines overlap?
 *
 * Answer: 22088
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    var grid = mutableMapOf<Coord, Int>()

    rows.map { r ->
        val statement = r.split(" -> ")

        val lhs = statement[0].split(",")
        val rhs = statement[1].split(",")

        val start = Coord(lhs[0].toInt(), lhs[1].toInt())
        val end = Coord(rhs[0].toInt(), rhs[1].toInt())

        //Pairs of Coords
        Pair(start,end)
    }.map { p ->
        //Build grid
        val a = p.first
        val b = p.second

        val sX = if (a.x == b.x) generateSequence (a.x) { it }.take(abs(a.y-b.y)+1) else (a.x towards b.x).asSequence()
        val sY = if (a.y == b.y) generateSequence (a.y) { it }.take(abs(a.x-b.x)+1) else (a.y towards b.y).asSequence()

        sY.zip(sX).forEach { pair ->
            val currentCoord = Coord(pair.first,pair.second)
            val oldValue = grid.getOrDefault(currentCoord, 0)
            grid[currentCoord] = oldValue+1
        }
        sY.zip(sX)
    }

    return grid.filter { e ->
        e.value > 1
    }.count()
}

private infix fun Int.towards(to: Int): IntProgression {

    return IntProgression.fromClosedRange(this, to, getStep(this, to))
}

fun getStep(a: Int, b: Int): Int{
    if (a<b)
        return 1
    else if (b<a)
        return -1
    throw RuntimeException("Numbers are equal, not supported")
}