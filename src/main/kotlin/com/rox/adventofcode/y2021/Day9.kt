package com.rox.adventofcode.y2021

import com.rox.adventofcode.cartesianProduct
import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
2199943210
3987894921
9856789892
8767896789
9899965678
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day9.input"))}")
    println("Part B: ${com.rox.adventofcode.y2021.solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day9.input"))}")
}

/**
 * --- Day 9: Smoke Basin ---
 *
 * These caves seem to be lava tubes. Parts are even still volcanically active; small hydrothermal vents release
 * smoke into the caves that slowly settles like rain.
 *
 * If you can model how the smoke flows through the caves, you might be able to avoid it and be that much safer.
 * The submarine generates a heightmap of the floor of the nearby caves for you (your puzzle input).
 *
 * Smoke flows to the lowest point of the area it's in. For example, consider the following heightmap:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 *
 * Each number corresponds to the height of a particular location, where 9 is the highest and 0 is the lowest a
 * location can be.
 *
 * Your first goal is to find the low points - the locations that are lower than any of its adjacent locations.
 * Most locations have four adjacent locations (up, down, left, and right); locations on the edge or corner of
 * the map have three or two adjacent locations, respectively. (Diagonal locations do not count as adjacent.)
 *
 * In the above example, there are four low points, all highlighted: two are in the first row (a 1 and a 0), one
 * is in the third row (a 5), and one is in the bottom row (also a 5). All other locations on the heightmap have
 * some lower adjacent location, and so are not low points.
 *
 * The risk level of a low point is 1 plus its height. In the above example, the risk levels of the low points
 * are 2, 1, 6, and 6. The sum of the risk levels of all low points in the heightmap is therefore 15.
 *
 * Find all of the low points on your heightmap. What is the sum of the risk levels of all low points on your
 * heightmap?
 *
 * Answer: 498
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val heightmap = Array(rows.size) { IntArray(rows[0].length) }

    for (rowIndex in rows.indices){
        heightmap[rowIndex] = rows[rowIndex].toCharArray().map { c -> "$c".toInt() }.toIntArray()
    }

    return lowestPoints(heightmap).map { p -> heightmap[p.first][p.second] + 1 }.sum()
}

private fun lowestPoints(heightmap: Array<IntArray>): List<Pair<Int, Int>> {
    val lowestPoints = mutableListOf<Pair<Int, Int>>()
    rows@ for (y in heightmap.indices) {
        cols@ for (x in heightmap[0].indices) {
            if (heightmap[y][x] == 9)
                continue@cols

            val validY = mutableListOf(y)
            if (y > 0) validY.add(y - 1)
            if (y < heightmap.size - 1) validY.add(y + 1)

            val validX = mutableListOf(x)
            if (x > 0) validX.add(x - 1)
            if (x < heightmap[0].size - 1) validX.add(x + 1)

            val nearbyHeights = cartesianProduct(validY, validX).filter {
                //Exclude diagonals and x,y
                    e ->
                (e.first == y || e.second == x) && (e.first != y || e.second != x)
            }.map { c -> heightmap[c.first][c.second] }

            if (nearbyHeights.all { c -> c > heightmap[y][x] }) {
                lowestPoints.add(Pair(y, x))
            }
        }
    }

    return lowestPoints
}

/**
 * --- Part Two ---
 *
 * Next, you need to find the largest basins so you know what areas are most important to avoid.
 *
 * A basin is all locations that eventually flow downward to a single low point. Therefore, every
 * low point has a basin, although some basins are very small. Locations of height 9 do not count
 * as being in any basin, and all other locations will always be part of exactly one basin.
 *
 * The size of a basin is the number of locations within the basin, including the low point. The
 * example above has four basins.
 *
 * The top-left basin, size 3:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The top-right basin, size 9:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The middle basin, size 14:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The bottom-right basin, size 9:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * Find the three largest basins and multiply their sizes together. In the above example, this is 9 * 14 * 9 = 1134.
 *
 * What do you get if you multiply together the sizes of the three largest basins?
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val heightmap = Array(rows.size) { IntArray(rows[0].length) }

    for (rowIndex in rows.indices){
        heightmap[rowIndex] = rows[rowIndex].toCharArray().map { c -> "$c".toInt() }.toIntArray()
    }

    return lowestPoints(heightmap)
        .map { lowestPoint -> mapBasin(lowestPoint, heightmap) }
        .sortedBy { basin -> basin.size }
        .reversed()
        .take(3)
        .map { basin -> basin.size }
        .fold(1) { answer, size -> size * answer }
}

val visitedPoints = mutableListOf<Pair<Int,Int>>()


fun mapBasin(point: Pair<Int,Int>, heatmap: Array<IntArray>): Basin {
    //XXX Could pre-compile all the high points as "visited" to save this double check
    if (heatmap[point.first][point.second] == 9 || visitedPoints.contains(point))
        return listOf()
    else
        visitedPoints.add(point)

    val basin = mutableListOf(point)

    if (point.first > 0)
        basin.addAll(mapBasin(Pair(point.first-1, point.second), heatmap))
    if (point.second > 0)
        basin.addAll(mapBasin(Pair(point.first, point.second-1), heatmap))
    if (point.first < heatmap.size-1)
        basin.addAll(mapBasin(Pair(point.first+1, point.second), heatmap))
    if (point.second < heatmap[0].size-1)
        basin.addAll(mapBasin(Pair(point.first, point.second+1), heatmap))

    return basin.toList()
}

typealias Basin = List<Pair<Int,Int>>

