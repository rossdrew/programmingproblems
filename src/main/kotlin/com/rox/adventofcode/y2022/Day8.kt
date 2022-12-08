package com.rox.adventofcode.y2022

import com.rox.adventofcode.CardinalDirection
import com.rox.adventofcode.DirectionalCoord
import com.rox.adventofcode.SimpleCoord
import com.rox.adventofcode.puzzleInputFromFile
import com.rox.adventofcode.y2018.Coordinate

private val inputSample = """
30373
25512
65332
33549
35390
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day8.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day8.input"))}")
}

/**
 *
 *
 * Answer: 1870
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val typedRows = rows.map { row -> row.map { c -> Integer.parseInt("$c") } }
    val visibleTrees = mutableSetOf<SimpleCoord>()

    (rows.indices).forEach { row ->
        (typedRows[row].indices).forEach{ treeIndex ->
            val subject = typedRows[row][treeIndex]
            val a = typedRows[row].slice(0 until treeIndex).ifEmpty { listOf(-1) }
            val b = typedRows[row].slice(treeIndex+1 until typedRows[row].size).ifEmpty { listOf(-1) }

            if (subject > a.max() as Int || subject > b.max() as Int){
                visibleTrees.add(SimpleCoord(treeIndex, row))
            }
        }
    }

    (rows[0].indices).map { x ->
        val typedColumn = rows.mapIndexed { y, row -> Integer.parseInt("${row[x]}") }

        for (y in typedColumn.indices){
            val subject = typedColumn[y]
            val a = typedColumn.slice(0 until y).ifEmpty { listOf(-1) }
            val b = typedColumn.slice(y+1 until typedColumn.size).ifEmpty { listOf(-1) }

            if (subject > a.max() as Int || subject > b.max() as Int){
                visibleTrees.add(SimpleCoord(x, y))
            }
        }
    }

    return visibleTrees.size
}

/**
 *
 * Answer: 517440
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    var grid = mutableMapOf<SimpleCoord, Int>()
    for (y in rows.indices){
        for (x in rows[y].indices){
            grid[SimpleCoord(x,y)] = Integer.parseInt("${rows[y][x]}")
        }
    }

    var longestView: Pair<Int, SimpleCoord> = Pair(0, SimpleCoord(-1,-1))

    for (y in rows.indices){
        for (x in rows[y].indices){
            val myLocation = SimpleCoord(x,y)
            val me: Int = grid[myLocation] as Int

            val left = (x-1 downTo 0).map { xx -> SimpleCoord(xx,y) }.filter { it.x in (rows[y].indices) }
            val right = (x+1 until rows[y].length).map{xx -> SimpleCoord(xx,y)}.filter { it.x in (rows[y].indices) }
            val up = (y-1 downTo  0).map { yy -> SimpleCoord(x,yy) }.filter { it.y in (rows.indices) }
            val down = (y+1 until rows.size).map { yy -> SimpleCoord(x,yy) }.filter { it.y in (rows.indices) }

            val s = listOf(up,left,down,right).map { direction ->
                println(myLocation)
                val indexOfFirst = (direction.indices).indexOfFirst { i -> (grid[direction[i]] as Int) >= me }
                if (indexOfFirst == -1) direction.size else indexOfFirst+1
            }
            val product = s.reduce { acc, i ->  acc * i }

            if (longestView.first < product)
                longestView = Pair(product, myLocation)
        }
    }

    return longestView.first
}

