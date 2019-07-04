package com.rox.adventofcode.y2018

import kotlin.math.abs

private val sampleInput = """
1, 1
1, 6
8, 3
3, 4
5, 5
8, 9
""".trimIndent()

private val inputA = """
    342, 203
79, 64
268, 323
239, 131
246, 87
161, 93
306, 146
43, 146
57, 112
241, 277
304, 303
143, 235
253, 318
97, 103
200, 250
67, 207
345, 149
133, 222
232, 123
156, 359
80, 224
51, 145
138, 312
339, 294
297, 256
163, 311
241, 321
126, 66
145, 171
359, 184
241, 58
108, 312
117, 118
101, 180
58, 290
324, 42
141, 190
270, 149
209, 294
296, 345
68, 266
233, 281
305, 183
245, 230
161, 295
335, 352
93, 66
227, 59
264, 249
116, 173
""".trimIndent()

fun main(args: Array<String>) {
    val input = sampleInput.split('\n')

    println("Part A: ${solutionA(input)}")
    println("Part B: ${solutionB(input)}")
}

/**
 * --- Day 6: Chronal Coordinates ---
 * The device on your wrist beeps several times, and once again you feel like you're falling.
 *
 * "Situation critical," the device announces. "Destination indeterminate. Chronal interference detected. Please specify
 * new target coordinates."
 *
 * The device then produces a list of coordinates (your puzzle input). Are they places it thinks are safe or dangerous?
 * It recommends you check manual page 729. The Elves did not give you a manual.
 *
 * If they're dangerous, maybe you can minimize the danger by finding the coordinate that gives the largest distance
 * from the other points.
 *
 * Using only the Manhattan distance, determine the area around each coordinate by counting the number of integer X,Y
 * locations that are closest to that coordinate (and aren't tied in distance to any other coordinate).
 *
 * Your goal is to find the size of the largest area that isn't infinite. For example, consider the following list of
 * coordinates:
 *
 * 1, 1
 * 1, 6
 * 8, 3
 * 3, 4
 * 5, 5
 * 8, 9
 * If we name these coordinates A through F, we can draw them on a grid, putting 0,0 at the top left:
 *
 * ..........
 * .A........
 * ..........
 * ........C.
 * ...D......
 * .....E....
 * .B........
 * ..........
 * ..........
 * ........F.
 * This view is partial - the actual grid extends infinitely in all directions. Using the Manhattan distance, each
 * location's closest coordinate can be determined, shown here in lowercase:
 *
 * aaaaa.cccc
 * aAaaa.cccc
 * aaaddecccc
 * aadddeccCc
 * ..dDdeeccc
 * bb.deEeecc
 * bBb.eeee..
 * bbb.eeefff
 * bbb.eeffff
 * bbb.ffffFf
 * Locations shown as . are equally far from two or more coordinates, and so they don't count as being closest to any.
 *
 * In this example, the areas of coordinates A, B, C, and F are infinite - while not shown here, their areas extend
 * forever outside the visible grid. However, the areas of coordinates D and E are finite: D is closest to 9 locations,
 * and E is closest to 17 (both including the coordinate's location itself). Therefore, in this example, the size of the
 * largest area is 17.
 *
 * What is the size of the largest area that isn't infinite?
 */
private fun solutionA(entries : List<String>): Any {
    val coords = entries.map { coordinateString ->
        val coordElements = coordinateString.split(",")
        Coordinate(coordElements[0].trim().toInt(), coordElements[1].trim().toInt())
    }

    //figure out finite space (smallest X and Y to largest X and Y)
    //XXX Is there a nicer Kotlin way of doing this?  (without all the `?` and `!!`
    val finiteSpaceStart = Coordinate((coords.minBy { it.x })?.x!!,
                                       coords.minBy { it.y }?.y!!)

    val finiteSpaceEnd = Coordinate((coords.maxBy { it.x })?.x!!,
                                     coords.maxBy { it.y }?.y!!)

    // - Brute Force Approach: Calculate the Manhatten distance for each empty space, to each occupied space
    //   then chose the smallest and if it's unique, boom
    val grid = Array(finiteSpaceEnd.y + 1) { arrayOfNulls<DistanceAndLocation>(finiteSpaceEnd.x + 1) }

    for (y in 0 .. finiteSpaceEnd.y) {
        for (x in 0 .. finiteSpaceEnd.x) {
            grid[y][x] = DistanceAndLocation(0, Coordinate(1,1))

            // for each item, get a list of all unique distances and chose the smallest
            //XXX The description says to do this but in the example, at 0x5, the shortest unique is B.  In the example, it's empty
            val closestDistinct = coords.map { coord ->
                DistanceAndLocation(manhattanDistance(coord, x, y), coord)
            }.exclusiveDistinctBy { it.distance }.minBy { it.distance }

            println("${y}x$x: Closest is $closestDistinct")
            grid[y][x] = closestDistinct
        }
    }

    //The count of the location that appears the most is the answer
    //TODO Still wrong as it's taking into account the ones that are left out above
    return grid.flatten()
               .groupBy { it?.location }.values
               .map { it.size }
               .max()!!
}

private fun manhattanDistance(coord: Coordinate, x: Int, y: Int): Int {
    val deltaX = (coord.x - x)
    val deltaY = (coord.y - y)

    return abs(deltaX) + abs(deltaY)
}

/**
 * Return only the elements which are distinct in this map given a selector
 */
inline fun <T, K> Iterable<T>.exclusiveDistinctBy(selector: (T) -> K): List<T> {
    val tmpMap: MutableMap<K, T> = mutableMapOf()

    for (element in this) {
        val key = selector(element)

        if (tmpMap.containsKey(key)){
            tmpMap.remove(key)
        } else {
            tmpMap[key] = element
        }
    }
    return tmpMap.values.toList()
}

private fun solutionB(entries : List<String>): Any {
    return "To be implemented!"
}

private class DistanceAndLocation(val distance: Int, val location: Coordinate) {
    override fun toString(): String {
        return "DistanceAndLocation(distance=$distance, location=$location)"
    }
}