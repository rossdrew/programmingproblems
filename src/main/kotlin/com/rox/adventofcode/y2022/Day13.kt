package com.rox.adventofcode.y2022

import java.rmi.UnexpectedException
import java.util.*

private val inputSample = """
[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
    //println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
}

/**
 *
 *
 * Answer: ???
 */
private fun solutionA(input: String): Any {
    val packetPairs = input.split("\n\n")

    for (pairIndex in packetPairs.indices){
        val (packetA,packetB) = packetPairs[pairIndex].split('\n')

        val leftGroup = parseSignal(packetA)
        val rightGroup = parseSignal(packetB)

        val ordered = areOrdered(leftGroup, rightGroup)

        //add pairIndex to sum
        println("")
    }

    return input
}

fun areOrdered(leftGroup: Group, rightGroup: Group): Any {
    val i = 0
    when (leftGroup.signalGroup[i].getType()){
        //both values are lists, compare the first value of each list, then the second value, and so on. If the left list runs out of items first, the inputs are in the right order. If the right list runs out of items first, the inputs are not in the right order.
        SignalEntryType.GROUP -> {
            val leftSignal = leftGroup.signalGroup[i].asGroup()
            val rightSignal = rightGroup.signalGroup[i].asGroup()
            false
        }
        //both values are integers, the lower integer should come first
        //exactly one value is an integer, convert the integer to a list which contains that integer as its only value, then retry the comparison
        SignalEntryType.DATA -> {
            if (rightGroup.signalGroup[i].getType() == SignalEntryType.GROUP) {
                val leftSignal = leftGroup.signalGroup[i].asGroup()
            }else{
                val leftSignal = leftGroup.signalGroup[1].asData()
            }
            false
        }
    }


    return false
}

private fun parseSignal(packetA: String): Group {
    val groups = Stack<Group>()
    var tmpContent = ""
    for (a_i in packetA.indices) {
        when (packetA[a_i]) {
            '[' -> groups.push(Group())
            ']' -> {
                if (a_i + 1 < packetA.length) {
                    val completedGroup = groups.pop()
                    groups.peek().addSignalEntry(completedGroup)
                }
            }
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                //read all content
                tmpContent += packetA[a_i]
                //create Data
                groups.peek().addSignalEntry(Data(tmpContent))
            }
            ',' -> {
                tmpContent = ""
                //do nothing, next item...
            }
        }
    }
    return groups.pop().asGroup()
}

enum class SignalEntryType {
    GROUP,
    DATA
}

interface SignalEntry {
    fun getType() : SignalEntryType
    fun asGroup(): Group
    fun asData(): Data
}

data class Group(val signalGroup: MutableList<SignalEntry> = mutableListOf()) : SignalEntry {
    override fun getType() = SignalEntryType.GROUP
    override fun asGroup() = this
    override fun asData() = throw UnexpectedException("Group cannot be read as data")

    fun addSignalEntry(signalEntry: SignalEntry){
        signalGroup.add(signalEntry)
    }
}


data class Data(var content: String = "") : SignalEntry{
    override fun getType() = SignalEntryType.DATA
    override fun asGroup() = Group(listOf(this).toMutableList())
    override fun asData() = this
}


/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

