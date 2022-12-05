package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.abs

private val inputSample = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day5.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day5.input"))}")
}

/**
 *
 *
 * Answer: ???
 */
private fun solutionA(input: String): Any {
    val section = input.split("\n\n")
    val instructions = section[1].split("\n")

    //Build stacks
    val height = section[0].split("\n")
    val stackIndices = height.takeLast(1)[0].trim().split("  ").map { i -> Integer.parseInt(i.trim()) }

    val abstractStack = mutableMapOf<Int,String>()
    stackIndices.forEach{i -> abstractStack[i] = ""}

    for (heightIndex in height.size - 2 downTo 0 ){
        stackIndices.forEach { stackIndex ->
            val columnIndex = ((stackIndex-1)*3+((stackIndex-1)*1))+1
            if (height[heightIndex].length > columnIndex && height[heightIndex][columnIndex] != ' ') {
                val box = height[heightIndex][columnIndex]
                abstractStack[stackIndex] = abstractStack[stackIndex] + box
            }
        }
    }

    //Follow instructions
    instructions
        .map { i -> i.replace("move","").replace("from","").replace("to","").trim().replace("  ", " ").split(" ")}
        .forEach{instruction ->
            val count = Integer.parseInt(instruction[0])
            val source = Integer.parseInt(instruction[1])
            val destination = Integer.parseInt(instruction[2])

            (1..count).forEach { step ->
                val tmp = abstractStack[source] as String

                abstractStack[destination] = "${abstractStack[destination]}${tmp.last()}"
                abstractStack[source] = "${tmp.subSequence(0, tmp.length-1)}"
            }
    }

    return abstractStack.map { e -> e.value.last() }.joinToString().replace(", ","")
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val section = input.split("\n\n")
    val instructions = section[1].split("\n")

    //Build stacks
    val height = section[0].split("\n")
    val stackIndices = height.takeLast(1)[0].trim().split("  ").map { i -> Integer.parseInt(i.trim()) }

    val abstractStack = mutableMapOf<Int,String>()
    stackIndices.forEach{i -> abstractStack[i] = ""}

    for (heightIndex in height.size - 2 downTo 0 ){
        stackIndices.forEach { stackIndex ->
            val columnIndex = ((stackIndex-1)*3+((stackIndex-1)*1))+1
            if (height[heightIndex].length > columnIndex && height[heightIndex][columnIndex] != ' ') {
                val box = height[heightIndex][columnIndex]
                abstractStack[stackIndex] = abstractStack[stackIndex] + box
            }
        }
    }

    //Follow instructions
    instructions
        .map { i -> i.replace("move","").replace("from","").replace("to","").trim().replace("  ", " ").split(" ")}
        .forEach{instruction ->
            val count = Integer.parseInt(instruction[0])
            val source = Integer.parseInt(instruction[1])
            val destination = Integer.parseInt(instruction[2])

            val tmp = abstractStack[source] as String
            abstractStack[destination] = "${abstractStack[destination]}${tmp.takeLast(count)}"
            abstractStack[source] = "${tmp.subSequence(0, tmp.length-count)}"
        }

    return abstractStack.map { e -> e.value.last() }.joinToString().replace(", ","")
}

