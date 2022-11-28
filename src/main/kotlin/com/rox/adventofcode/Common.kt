package com.rox.adventofcode

import java.io.File
import kotlin.math.abs

fun puzzleInputFromFile(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

fun <TypeA, TypeB> cartesianProduct(A: Collection<TypeA>, B: Collection<TypeB>): List<Pair<TypeA, TypeB>> {
    return A.flatMap {
            a -> B.map {
                b -> a to b
            }
    }
}

fun parseGrid(rows: List<String>): Array<IntArray>{
    val grid = Array(rows.size) { IntArray(rows[0].length) }
    for (rowIndex in rows.indices){
        grid[rowIndex] = rows[rowIndex].toCharArray().map { c -> "$c".toInt() }.toIntArray()
    }
    return grid
}


fun parseGrid(rows: List<String>, conversionFunction: (input: String) -> Int): Array<IntArray>{
    val grid = Array(rows.size) { IntArray(rows[0].length) }
    for (rowIndex in rows.indices){
        grid[rowIndex] = rows[rowIndex].toCharArray().map { c -> conversionFunction("$c") }.toIntArray()
    }
    return grid
}

/**
 * Yield the elements of this list infinitely
 */
fun <T> List<T>.infiniteSequence(): Sequence<T> = sequence {
    if (this@infiniteSequence.isEmpty()) {
        return@sequence
    }
    while (true) {
        yieldAll(this@infiniteSequence)
    }
}

/**
 * A Co-ordinate on a Cartesian plane
 */
data class SimpleCoord(val x: Int, val y: Int)

//TODO Add SimpleCoord transformers?
enum class CardinalDirection {
    NORTH, SOUTH, WEST, EAST
}

data class DirectionalCoord(val location: SimpleCoord, val direction: CardinalDirection)

/**
 * Calculate the manhattan distance between two {@link Coord}s
 */
fun manhattanDistance(pointA: SimpleCoord, pointB: SimpleCoord): Int {
    val deltaX = (pointA.x - pointB.x)
    val deltaY = (pointA.y - pointB.y)

    return abs(deltaX) + abs(deltaY)
}

/**
 * Translate string of key value pairs into a map that is
 *
 * KeyA <i>entryDelimiter</i> ValueA <i>pairDelimiter</i> KeyB <i>entryDelimiter</i> ValueB
 * becomes [KeyA:ValueA, KeyB:ValueB]
 */
fun parseMap(passportData: String,
                  entryDelimiter: String = " ",
                  pairDelimiter: String = ":"): Map<String, String> {
    return passportData
        .split(entryDelimiter)
        .filter { it.isNotBlank() }
        .map { entry ->
            with(entry.split(pairDelimiter)) {
                this[0] to this[1]
            }
        }.toMap()
}