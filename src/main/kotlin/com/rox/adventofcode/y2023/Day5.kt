package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile
import kotlin.math.min

private val inputSample = """
seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48

soil-to-fertilizer map:
0 15 37
37 52 2
39 0 15

fertilizer-to-water map:
49 53 8
0 11 42
42 0 7
57 7 4

water-to-light map:
88 18 7
18 25 70

light-to-temperature map:
45 77 23
81 45 19
68 64 13

temperature-to-humidity map:
0 69 1
1 0 69

humidity-to-location map:
60 56 37
56 93 4
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day5.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day5.input"))}")
}

data class CategoryConversion(val from: String, val to: String, val mappings: MutableList<RangeAndOffset>){
    fun getMappingFor(value: Long): Long {
        val mappedValue = mappings.firstOrNull { m -> value in m.range }
        if (mappedValue != null) return (value + mappedValue.offset) else return value
    }
}

data class RangeAndOffset(val range: LongRange, val offset: Long)

/**
 * Answer: ???
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    val seedsToPlant = rows[0].substring("seeds: ".length).split(" ").map { i -> i.toLong() }

    val categories = mutableMapOf<String, CategoryConversion>()
    var parseIndex = 1
    for (block in 0 .. 6) {
        parseIndex++
        val (from, to) = rows[parseIndex++].split(" ")[0].split("-to-")
        val mappedRanges = mutableListOf<RangeAndOffset>()

        while (parseIndex < rows.size && rows[parseIndex].isNotEmpty()){
            val (destination, source, count) = rows[parseIndex++].split(" ").map { entry -> entry.toLong() }
            val sourceRange = (source..(source + (count - 1)))
            mappedRanges.add(RangeAndOffset(sourceRange, destination - source))
        }

        categories[from] = CategoryConversion(from, to, mappedRanges)
    }

    var nearestSeed = Long.MAX_VALUE
    for (seed in seedsToPlant) {
        var seedProgress = seed
        for (stage in listOf("seed", "soil", "fertilizer", "water", "light", "temperature", "humidity")){
            seedProgress = categories[stage]?.getMappingFor(seedProgress)!!
            println("$stage: $seedProgress")
        }
        nearestSeed = min(nearestSeed, seedProgress)
    }

    return nearestSeed
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
//    val rows = input.split('\n')
//    val seedRanges = rows[0].substring("seeds: ".length).split(" ").map { i -> i.toLong() }
//    val seedsToPlant = mutableListOf<LongRange>()
//    for (i in seedRanges.indices step 2){
//        println("$i...")
//        seedsToPlant.add(seedRanges[i] until seedRanges[i]+seedRanges[i+1])
//    }
//
//    val categories = mutableMapOf<String, CategoryConversion>()
//    var parseIndex = 1
//    for (block in 0 .. 6) {
//        parseIndex++
//        val (from, to) = rows[parseIndex++].split(" ")[0].split("-to-")
//        val mappedRanges = mutableListOf<RangeAndOffset>()
//
//        while (parseIndex < rows.size && rows[parseIndex].isNotEmpty()){
//            val (destination, source, count) = rows[parseIndex++].split(" ").map { entry -> entry.toLong() }
//            val sourceRange = (source..(source + (count - 1)))
//            mappedRanges.add(RangeAndOffset(sourceRange, destination - source))
//        }
//
//        categories[from] = CategoryConversion(from, to, mappedRanges)
//    }
//
//    var nearestSeed = Long.MAX_VALUE
//    for (seed in seedsToPlant) {
//        var seedProgress = seed
//        for (stage in listOf("seed", "soil", "fertilizer", "water", "light", "temperature", "humidity")){
//            seedProgress = categories[stage]?.getMappingFor(seedProgress)!!
//            println("$stage: $seedProgress")
//        }
//        nearestSeed = min(nearestSeed, seedProgress)
//    }
//
//    return nearestSeed
}