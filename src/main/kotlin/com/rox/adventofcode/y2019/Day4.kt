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

 Answer: 910
 */
private fun solutionA(input : String) : Int? {
    val range = input.split('-').map { it.toInt() }

    val workingRange = range[0]..range[1]
    val filteredRange = workingRange.map { it.toString() }.filter { candidate ->
        candidate.length == 6 &&
        digitRepeats(candidate) { it > 1} &&
        candidate.toCharArray().sortedBy{it} == candidate.toList()
    }

    return filteredRange.size
}

/**
 * --- Part Two ---
An Elf just remembered one more important detail: the two adjacent matching digits are not part of a larger group of
matching digits.

Given this additional criterion, but still ignoring the range rule, the following are now true:

112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
How many different passwords within the range given in your puzzle input meet all of the criteria?

 ANSWER: 598
 */
private fun solutionB(input : String) : Int? {
    val range = input.split('-').map { it.toInt() }

    val workingRange = range[0]..range[1]
    val filteredRange = workingRange.map { it.toString() }.filter { candidate ->
        candidate.length == 6 &&
        digitRepeats(candidate) { it == 2 } &&
        candidate.toCharArray().sortedBy{it} == candidate.toList()
    }

    return filteredRange.size
}

/**
 * Are there any repaeting digits in candidate.  A predicate function is used to describe the repeating behaviour
 * to be met, examples:
 *
 * <code>{it > 2></code>: Will match if any character is repeated more than once
 * <code>{it == 2}</code>: Will match if any character repeats exactly twice
 */
private fun digitRepeats(candidate: String, predicate: (v: Int) -> Boolean): Boolean {
    candidate.toCharArray().distinct().forEach{char ->
        if (predicate(candidate.split(char).size - 1))
            return true
    }
    return false
}