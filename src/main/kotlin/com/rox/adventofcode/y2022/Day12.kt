package com.rox.adventofcode.y2022

import com.rox.adventofcode.SimpleCoord
import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException

private val inputSample = """
Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day12.input"))}")
    //println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
}

/**
 *
 *
 * Answer: 468
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val tacticalMap = generateTacticalMap(rows)
    val (distances, visited) = proceduralDijkstra(tacticalMap)

    return distances[tacticalMap.destination].toString()
}

private fun proceduralDijkstra(tacticalMap: TacticalMap,
                               unvisitedList: List<SimpleCoord> = tacticalMap.locations(),
                               distanceMap: Distance = mapOf(tacticalMap.location to 0L)): Pair<Distance, MutableList<SimpleCoord>> {
    var currentNode = tacticalMap.location
    var unvisited = unvisitedList.toMutableList()
    var distances = distanceMap.toMutableMap()

    println("Nodes: $unvisitedList")
    do {
        tacticalMap.getAdjacentLocations(currentNode).filter { node ->
            unvisitedList.contains(node) && (tacticalMap.getAtLocation(node) - tacticalMap.getAtLocation(currentNode) <= 1)
        }.map { unvisitedNode ->
            val myDistance = distances.getOrElse(currentNode, {throw UnexpectedException("${currentNode} should know it's own distance")})
            unvisitedNode to myDistance + 1
        }.forEach { nodeAndDistance ->
            if (distances.getOrDefault(nodeAndDistance.first, Long.MAX_VALUE) > nodeAndDistance.second){
                distances[nodeAndDistance.first] = nodeAndDistance.second
            }
        }
        unvisited.remove(currentNode)

        val paths = distances.filter { d -> unvisited.contains(d.key) }.map { d -> d.key }
        if (paths.isNotEmpty()){
            currentNode = paths.first()
        }
        println("Nodes: $unvisitedList")
    } while (paths.isNotEmpty())

    return Pair(distances, unvisited)
}

/**
 * Recursive Dijkstra's Algorithm
 */
private fun recursiveDijkstra(tacticalMap: TacticalMap,
                              unvisitedList: List<SimpleCoord> = tacticalMap.locations(),
                              distanceMap: Distance = mapOf(tacticalMap.location to 0L)): Pair<Distance, MutableList<SimpleCoord>> {
    var unvisited = unvisitedList.toMutableList()
    var distances = distanceMap.toMutableMap()

    //println("Investigating ${tacticalMap.location}...")

    //Update neighbouring distances
    tacticalMap.getAdjacentLocations().filter { cell ->
        //All unvisited cells, adjacent to this one which are 1 higher at most
        unvisitedList.contains(cell) && (tacticalMap.getAtLocation(cell) - tacticalMap.getAtLocation() <= 1)
    }.map { unvisitedNeighbour ->
        //Generate pairs of neighbour location to their distance made up of our distance + 1 (as all paths are 1 here)
        val myDistance = distances.getOrElse(tacticalMap.location, {throw UnexpectedException("${tacticalMap.location} should know it's own distance")})
        unvisitedNeighbour to myDistance + 1
    }.forEach{distanceToNeighbour ->
        //Compare gathered values to what exists for each in distances and use the smaller of the two
        //Replace existing distance to node with shorter one
        if (distances.getOrDefault(distanceToNeighbour.first, Long.MAX_VALUE) > distanceToNeighbour.second){
            //println("\t${distanceToNeighbour.first} shortest distance becomes ${distanceToNeighbour.second}")
            distances[distanceToNeighbour.first] = distanceToNeighbour.second
        }
    }
    //Paths from me have been updated, consider me visited
    unvisited.remove(tacticalMap.location)
    //println("\tMarking ${tacticalMap.location} as visited.")

    val paths = distances.filter { d -> unvisited.contains(d.key) }.map { d -> d.key }
    if (paths.isNotEmpty()){
        val updatedTacticalMap = TacticalMap(paths.first(), tacticalMap.destination, tacticalMap.map)
        //println("\t>Selecting ${paths.first()} from $paths")
        val (newDistances, newUnvisited) = recursiveDijkstra(
            updatedTacticalMap,
            unvisited,
            distances
        )
        distances = newDistances.toMutableMap()
        unvisited = newUnvisited
    }

    //Recurse on tactical map with new location and visited locations
    return Pair(distances, unvisited)
}

typealias Grid = Array<CharArray>
typealias Distance = Map<SimpleCoord, Long>

data class TacticalMap(val location: SimpleCoord,
                       val destination: SimpleCoord,
                       val map: Grid){
    fun locations(): List<SimpleCoord> {
        return map.indices.flatMap { y ->
            map[y].indices.map { x -> SimpleCoord(x,y) }
        }
    }

    fun getAtLocation(): Char {
        return getAtLocation(location)
    }

    fun getAtLocation(coords: SimpleCoord): Char {
        return map[coords.y][coords.x]
    }

    fun getAdjacentLocations(): List<SimpleCoord> {
        return getAdjacentLocations(location)
    }

    //TODO Option to exclude diagonals
    fun getAdjacentLocations(coords: SimpleCoord): List<SimpleCoord> {
        /*
        -1-1 | 0,-1 | +1-1
        ------------------
        -1,0 | 0,0  | +1,0
        ------------------
        -1+1,| 0,+1 | +1,+1

        if x=0 remove left col
        if x=length remove right col
        if y=0 remove top row
        if y=length remove bottom row
         */
        return mutableListOf(
            //Top row
            //SimpleCoord(coords.x-1,coords.y-1),
            SimpleCoord(coords.x, coords.y - 1),
            //SimpleCoord(coords.x+1, coords.y - 1),
            //Middle row
            SimpleCoord(coords.x-1,coords.y),
            SimpleCoord(coords.x+1,coords.y),
            //Bottom row
            //SimpleCoord(coords.x-1,coords.y+1),
            SimpleCoord(coords.x,coords.y+1)
            //SimpleCoord(coords.x+1,coords.y+1)
        )
            .filter { cell -> cell.y >= 0 //within bounds
                && cell.y <= map.size-1
                && cell.x >= 0
                && cell.x <= map[0].size-1}.toList()

    }
}

private fun generateTacticalMap(rows: List<String>) : TacticalMap {
    var me = SimpleCoord(-1, -1)
    var destination = SimpleCoord(-1, -1)

    val grid = Array(rows.size) { CharArray(rows[0].length) }
    for (y in rows.indices) {
        for (x in rows[y].indices) {
            grid[y][x] = when (rows[y][x]) {
                'S' -> {
                    me = SimpleCoord(x, y)
                    'a'
                }
                'E' -> {
                    destination = SimpleCoord(x, y)
                    'z'
                }
                else -> rows[y][x]
            }
        }
    }

    return TacticalMap(me, destination, grid)
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

