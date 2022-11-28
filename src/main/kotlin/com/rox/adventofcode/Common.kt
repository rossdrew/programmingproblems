package com.rox.adventofcode

import java.io.File

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