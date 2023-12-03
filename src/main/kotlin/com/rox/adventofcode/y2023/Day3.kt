package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...${'$'}.*....
.664.598..
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day3.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day3.input"))}")
}

/**
 * Answer: 543867
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    var sum = 0;
    for (rowIndex in rows.indices){
        val row = rows[rowIndex]
        for (characterIndex in row.indices){
            if ((row[characterIndex] != '.') and !row[characterIndex].isDigit()) { //assume it's a character
                //left
                if (characterIndex > 0 && row[characterIndex-1].isDigit() ){
                    val n = row.substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                    //println(n)
                    sum += n.toInt();
                }
                //right
                if (characterIndex < row.length-1 && row[characterIndex+1].isDigit() ){
                    val n = row.substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                    //println(n)
                    sum += n.toInt();
                }

                //Up
                if (rowIndex > 0) {
                    if (rows[rowIndex-1][characterIndex] == '.'){
                        //two numbers
                        //Guard against double dots here?
                        val left = rows[rowIndex-1].substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        val right = rows[rowIndex-1].substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                        //println("$left & $right")
                        sum += (if (left.isNotEmpty()) left.toInt() else 0) + (if (right.isNotEmpty()) right.toInt() else 0)
                    }else if (rows[rowIndex-1][characterIndex-1] == '.'){
                        val right = rows[rowIndex-1].substring(characterIndex).takeWhile { c -> c.isDigit() }
                        sum += (if (right.isNotEmpty()) right.toInt() else 0)
                        //println("$right")
                    }else if (rows[rowIndex-1][characterIndex+1] == '.'){
                        val left = rows[rowIndex-1].substring(0, characterIndex+1).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        sum += (if (left.isNotEmpty()) left.toInt() else 0)
                        //println("$left")
                    }else if (!rows[rowIndex-1].subSequence(characterIndex-1, characterIndex+2).contains(".")){
                        //all number
                        val n = rows[rowIndex-1].subSequence(characterIndex-1, characterIndex+2)
                        sum += n.toString().toInt()
                    }
                }
                //Down
                if (rowIndex < rows.size) {
                    if (rows[rowIndex+1][characterIndex] == '.'){
                        //two numbers
                        //Guard against double dots here?
                        val left = rows[rowIndex+1].substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        val right = rows[rowIndex+1].substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                        sum += (if (left.isNotEmpty()) left.toInt() else 0) + (if (right.isNotEmpty()) right.toInt() else 0)
                        //println("$left & $right")
                    }else if (rows[rowIndex+1][characterIndex-1] == '.'){
                        val right = rows[rowIndex+1].substring(characterIndex).takeWhile { c -> c.isDigit() }
                        sum += (if (right.isNotEmpty()) right.toInt() else 0)
                        //println("$right")
                    }else if (rows[rowIndex+1][characterIndex+1] == '.'){
                        val left = rows[rowIndex+1].substring(0, characterIndex+1).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        sum += (if (left.isNotEmpty()) left.toInt() else 0)
                        //println("$left")
                    }else if (!rows[rowIndex+1].subSequence(characterIndex-1, characterIndex+2).contains(".")){
                        //all number
                        val n = rows[rowIndex+1].subSequence(characterIndex-1, characterIndex+2)
                        sum += n.toString().toInt()
                    }
                }
            }
        }
    }

    return sum
}

/**
 *
 * Answer: 79613331
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    var sum = 0;
    for (rowIndex in rows.indices){
        val row = rows[rowIndex]
        char@ for (characterIndex in row.indices){
            if ((row[characterIndex] == '*')) { //it's a gear
                var gearRatio = 1
                var gearNumbers = 0;

                //left
                if (characterIndex > 0 && row[characterIndex-1].isDigit() ){
                    val n = row.substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                    //println(n)
                    if (++gearNumbers > 3) continue@char
                    gearRatio *= n.toInt();
                }
                //right
                if (characterIndex < row.length-1 && row[characterIndex+1].isDigit() ){
                    val n = row.substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                    //println(n)
                    if (++gearNumbers > 3) continue@char
                    gearRatio *= n.toInt();
                }

                //Up
                if (rowIndex > 0) {
                    if (rows[rowIndex-1][characterIndex] == '.'){
                        //two numbers
                        //Guard against double dots here?
                        val left = rows[rowIndex-1].substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        val right = rows[rowIndex-1].substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                        //println("$left & $right")
                        if (left.isNotEmpty() && left.toInt() > 0) {
                            if (++gearNumbers > 3) continue@char
                            gearRatio *= left.toInt()
                        }
                        if (right.isNotEmpty() && right.toInt() > 0) {
                            if (++gearNumbers > 3) continue@char
                            gearRatio *= right.toInt()
                        }
                    }else if (rows[rowIndex-1][characterIndex-1] == '.'){
                        val right = rows[rowIndex-1].substring(characterIndex).takeWhile { c -> c.isDigit() }
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= (if (right.isNotEmpty()) right.toInt() else 0)
                        //println("$right")
                    }else if (rows[rowIndex-1][characterIndex+1] == '.'){
                        val left = rows[rowIndex-1].substring(0, characterIndex+1).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= (if (left.isNotEmpty()) left.toInt() else 0)
                        //println("$left")
                    }else if (!rows[rowIndex-1].subSequence(characterIndex-1, characterIndex+2).contains(".")){
                        //all number
                        val n = rows[rowIndex-1].subSequence(characterIndex-1, characterIndex+2)
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= n.toString().toInt()
                    }
                }
                //Down
                if (rowIndex < rows.size) {
                    if (rows[rowIndex+1][characterIndex] == '.'){
                        //two numbers
                        //Guard against double dots here?
                        val left = rows[rowIndex+1].substring(0, characterIndex).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        val right = rows[rowIndex+1].substring(characterIndex+1).takeWhile { c -> c.isDigit() }
                        //println("$left & $right")
                        if (left.isNotEmpty() && left.toInt() > 0) {
                            if (++gearNumbers > 3) continue@char
                            gearRatio *= left.toInt()
                        }
                        if (right.isNotEmpty() && right.toInt() > 0) {
                            if (++gearNumbers > 3) continue@char
                            gearRatio *= right.toInt()
                        }
                    }else if (rows[rowIndex+1][characterIndex-1] == '.'){
                        val right = rows[rowIndex+1].substring(characterIndex).takeWhile { c -> c.isDigit() }
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= (if (right.isNotEmpty()) right.toInt() else 0)
                        //println("$right")
                    }else if (rows[rowIndex+1][characterIndex+1] == '.'){
                        val left = rows[rowIndex+1].substring(0, characterIndex+1).reversed().takeWhile { c -> c.isDigit() }.reversed()
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= (if (left.isNotEmpty()) left.toInt() else 0)
                        //println("$left")
                    }else if (!rows[rowIndex+1].subSequence(characterIndex-1, characterIndex+2).contains(".")){
                        //all number
                        val n = rows[rowIndex+1].subSequence(characterIndex-1, characterIndex+2)
                        if (++gearNumbers > 3) continue@char
                        gearRatio *= n.toString().toInt()
                    }
                }
                if (gearNumbers == 2) {
                    sum += gearRatio
                }
            }
        }
    }

    return sum
}

