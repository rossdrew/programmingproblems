package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile

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
 * Answer: TWSGQHNHL
 */
private fun solutionA(input: String): Any {
    val section = input.split("\n\n")
    val instructions = section[1].split("\n")

    val abstractStack = extractStacks(section)
    return processStacks(instructions, abstractStack) { s -> s.reversed() }
}

/**
 *
 * Answer: JNRSCDWPP
 */
private fun solutionB(input: String): Any {
    val section = input.split("\n\n")
    val instructions = section[1].split("\n")

    val abstractStack = extractStacks(section)
    return processStacks(instructions, abstractStack)
}

/**
 * Given an indexed map of stacks (abstractStack), perform a series of instructions on them to create a new,
 * reordered stack and return the top item (Char) from each stack as a String
 */
private fun processStacks(instructions: List<String>,
                          abstractStack: MutableMap<Int, String>,
                          preMoveProcess: (s: String) -> String = {s->s}): String {
    instructions
        .map { i -> i.replace("move", "").replace("from", "").replace("to", "").trim().replace("  ", " ").split(" ") }
        .forEach { instruction ->
            val count = Integer.parseInt(instruction[0])
            val source = Integer.parseInt(instruction[1])
            val destination = Integer.parseInt(instruction[2])

            val tmpSourceData = abstractStack[source] as String
            abstractStack[destination] = "${abstractStack[destination]}${preMoveProcess(tmpSourceData.takeLast(count))}"
            abstractStack[source] = "${tmpSourceData.subSequence(0, tmpSourceData.length - count)}"
        }

    return abstractStack.map { e -> e.value.last() }.joinToString().replace(", ", "")
}

/**
 * Given a List of horizontal stack slices with an index on the bottom row,
 * return a List of vertical slices (as strings), one for each stack, mapped by index
 */
private fun extractStacks(stackData: List<String>): MutableMap<Int, String> {
    val abstractStack = mutableMapOf<Int, String>()

    val height = stackData[0].split("\n")
    val stackIndices = height.takeLast(1)[0].trim().split("  ").map { i -> Integer.parseInt(i.trim()) }
    for (heightIndex in height.size - 2 downTo 0) {
        stackIndices.forEach { stackIndex ->
            val columnIndex = ((stackIndex - 1) * 3 + ((stackIndex - 1) * 1)) + 1
            /* if there are boxes present */
            if (height[heightIndex].length > columnIndex && height[heightIndex][columnIndex] != ' ') {
                val box = height[heightIndex][columnIndex]
                abstractStack[stackIndex] = abstractStack[stackIndex] + box
            }
        }
    }
    return abstractStack
}

