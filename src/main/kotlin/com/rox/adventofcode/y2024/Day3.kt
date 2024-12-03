package com.rox.adventofcode.y2024

import com.rox.adventofcode.puzzleInputFromFile

private val inputSampleA = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
private val inputSampleB = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

private val edgeCase1_ACBB = "don't() mul(1,2) do() do()" //need to use reluctant '(.*?)' matching rather than greedy '(.*)'
private val edgeCase2_ACAB = "don't() mul(1,2) don't() do()"

fun main() {
    println("Sample Input A: ${solutionA(inputSampleA)}")
    println("Sample Input B: ${solutionB(inputSampleB)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day3.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2024/Day3.input"))}")
}

val mulFinder = Regex(pattern = "mul\\([0-9]{1,3},[0-9]{1,3}\\)")
val invalidStringFinder = Regex(pattern = "don\'t\\(\\)(.*?)do\\(\\)") //TODO Not working when we have "don't() mul(1,2) don't() do()"

/**
 *
 *
 * Answer: 180233229
 */
private fun solutionA(input: String): Any {
    val result = mulFinder.findAll(input)
        .map { it.value }
        .map { v ->
            val (l,r) = v.split(",")
            val leftOperand = l.substring(l.indexOf("(")+1).toLong()
            val rightOperand = r.substring(0,r.indexOf(")")).toLong()
            //println("'$v': $leftOperand x = $rightOperand = ${leftOperand * rightOperand}")
            leftOperand * rightOperand
        }.sum()

    return result
}

/**
 *
 * Answer:
 * 51366068 (too low)
 * 126322951 (too high)
 */
private fun solutionB(input: String): Any {
    val validInput = invalidStringFinder.replace(input, "")

    val map = mulFinder.findAll(validInput)
        .map { it.value }
        .map { v ->
            val (l,r) = v.split(",")
            val leftOperand = l.substring(l.indexOf("(")+1).toLong()
            val rightOperand = r.substring(0,r.indexOf(")")).toLong()
            //println("'$v': $leftOperand x = $rightOperand = ${leftOperand * rightOperand}")
            leftOperand * rightOperand
        }.sum()

    return map
}