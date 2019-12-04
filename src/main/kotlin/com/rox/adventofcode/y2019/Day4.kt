package com.rox.adventofcode.y2019

private val inputA = """273025-767253""".trimIndent()

fun main(args: Array<String>) {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 4: Secure Container ---
You arrive at the Venus fuel depot only to discover it's protected by a password. The Elves had written the password
on a sticky note, but someone threw it out.

However, they do remember a few key facts about the password:

It is a six-digit number.
The value is within the range given in your puzzle input.
Two adjacent digits are the same (like 22 in 122345).
Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?

 Answer: WRONG-TOO-HIGH 917
 */
private fun solutionA(input : String) : Int? {
    val range = input.split('-').map { it.toInt() }

    val workingRange = range[0]..range[1]
    val filterdRange = workingRange.filter { candidate ->
        candidate.toString().length == 6 &&
        candidate.toString().toCharArray().distinct().isNotEmpty() //&&
        candidate.toString().toCharArray().sortedBy{it} == candidate.toString().toList()
    }

    println(workingRange)
    println("${filterdRange.size} items: $filterdRange")

    return filterdRange.size()
}

/**
 */
private fun solutionB(input : String) : Int? {
    val range = input.split('-').map { it.toDouble() }
    throw java.lang.RuntimeException("Not Implemented")
}
