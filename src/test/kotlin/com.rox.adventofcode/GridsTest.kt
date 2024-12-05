package com.rox.adventofcode

import com.rox.adventofcode.TwoDGridDirection.*
import io.kotest.assertions.fail
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import io.kotest.matchers.shouldBe

class GridCoordTest : ShouldSpec({
    val aoc0424grid = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
            """
        .trimIndent()
        .split("\n")
        .map { row ->
            row.toCharArray()
                .map {
                        character -> character.toString()
                }
        }

    should("navigate in a valid way north"){
        val movingDirection = NORTH
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(1,0))

        testInvalidMutation(aoc0424grid, 1, 0,movingDirection, 1, -1)
    }

    should("navigate in a valid way north east"){
        val movingDirection = NE
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(2,0))

        testInvalidMutation(aoc0424grid, 1, 0, movingDirection, 2, -1)
        testInvalidMutation(aoc0424grid, 9, 1, movingDirection, 10, 0)
        testInvalidMutation(aoc0424grid, 9, 0, movingDirection, 10, -1)
    }

    should("navigate in a valid way west"){
        val movingDirection = WEST
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(0,1))

        testInvalidMutation(aoc0424grid, 0, 1, movingDirection, -1, 1)
    }

    should("navigate in a valid way south west"){
        val movingDirection = SW
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(0,2))

        testInvalidMutation(aoc0424grid, 1, 9, movingDirection, 0, 10)
        testInvalidMutation(aoc0424grid, 0, 1, movingDirection, -1, 2)
    }

    should("navigate in a valid way south"){
        val movingDirection = SOUTH
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(1,2))

        testInvalidMutation(aoc0424grid, 1, 9, movingDirection, 1, 10)
    }

    should("navigate in a valid way south west"){
        val movingDirection = SW
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(0,2))

        testInvalidMutation(aoc0424grid, 1, 9, movingDirection, 0, 10)
        testInvalidMutation(aoc0424grid, 0, 1, movingDirection, -1, 2)
    }

    should("navigate in a valid way west"){
        val movingDirection = SW
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(0,2))

        testInvalidMutation(aoc0424grid, 0, 1, movingDirection, -1, 2)
    }

    should("navigate in a valid way north west"){
        val movingDirection = NW
        val endInsideBoard = GridCoord(aoc0424grid, SimpleCoord(1,1)).mutate(movingDirection)
        endInsideBoard shouldBe GridCoord(aoc0424grid, SimpleCoord(0,0))

        testInvalidMutation(aoc0424grid, 0, 1, movingDirection, -1, 0)
        testInvalidMutation(aoc0424grid, 1, 0, movingDirection, 0, -1)
        testInvalidMutation(aoc0424grid, 0, 0, movingDirection, -1, -1)
    }

    should("create identical objects with either constructor"){
        val a = GridCoord(aoc0424grid, SimpleCoord(1,1))
        val b = GridCoord(aoc0424grid, 1,1)
        val x = GridCoord(aoc0424grid, SimpleCoord(5,6))
        val y = GridCoord(aoc0424grid, 5,6)

        a shouldBeEqual b
        x shouldBeEqual y
        b shouldBeEqual a
        y shouldBeEqual x

        x shouldNotBeEqual a
        a shouldNotBeEqual x
        y shouldNotBeEqual b
        b shouldNotBeEqual y
        y shouldNotBeEqual a
        a shouldNotBeEqual y
    }

    should("be able to generate list of (8) valid neighbours in open location in grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 1,0), NORTH),
            Neighbour(GridCoord(aoc0424grid, 2,0), NE),
            Neighbour(GridCoord(aoc0424grid, 2,1), EAST),
            Neighbour(GridCoord(aoc0424grid, 2,2), SE),
            Neighbour(GridCoord(aoc0424grid, 1,2), SOUTH),
            Neighbour(GridCoord(aoc0424grid, 0,2), SW),
            Neighbour(GridCoord(aoc0424grid, 0,1), WEST),
            Neighbour(GridCoord(aoc0424grid, 0,0), NW)
        )

        val startingLocation = GridCoord(aoc0424grid, 1,1)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 8
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (5) valid from top of grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 2,0), EAST),
            Neighbour(GridCoord(aoc0424grid, 2,1), SE),
            Neighbour(GridCoord(aoc0424grid, 1,1), SOUTH),
            Neighbour(GridCoord(aoc0424grid, 0,1), SW),
            Neighbour(GridCoord(aoc0424grid, 0,0), WEST)
        )

        val startingLocation = GridCoord(aoc0424grid, 1,0)

        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 5
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (3) valid from north west of grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 1,0), EAST),
            Neighbour(GridCoord(aoc0424grid, 1,1), SE),
            Neighbour(GridCoord(aoc0424grid, 0,1), SOUTH)
        )

        val startingLocation = GridCoord(aoc0424grid, 0,0)

        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 3
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (5) valid neighbours from the west of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 0,0), NORTH),
            Neighbour(GridCoord(aoc0424grid, 1,0), NE),
            Neighbour(GridCoord(aoc0424grid, 1,1), EAST),
            Neighbour(GridCoord(aoc0424grid, 1,2), SE),
            Neighbour(GridCoord(aoc0424grid, 0,2), SOUTH)
        )

        val startingLocation = GridCoord(aoc0424grid, 0,1)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 5
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (3) valid neighbours from the south west of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 0,8), NORTH),
            Neighbour(GridCoord(aoc0424grid, 1,8), NE),
            Neighbour(GridCoord(aoc0424grid, 1,9), EAST)
        )

        val startingLocation = GridCoord(aoc0424grid, 0,9)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 3
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (3) valid neighbours from the north east of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 9,1), SOUTH),
            Neighbour(GridCoord(aoc0424grid, 8,1), SW),
            Neighbour(GridCoord(aoc0424grid, 8,0), WEST)
        )

        val startingLocation = GridCoord(aoc0424grid, 9,0)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 3
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (3) valid neighbours from the south east of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 9,8), NORTH),
            Neighbour(GridCoord(aoc0424grid, 8,9), WEST),
            Neighbour(GridCoord(aoc0424grid, 8,8), NW)
        )

        val startingLocation = GridCoord(aoc0424grid, 9,9)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 3
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (5) valid neighbours from the east of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 9,0), NORTH),
            Neighbour(GridCoord(aoc0424grid, 9,2), SOUTH),
            Neighbour(GridCoord(aoc0424grid, 8,2), SW),
            Neighbour(GridCoord(aoc0424grid, 8,1), WEST),
            Neighbour(GridCoord(aoc0424grid, 8,0), NW)
        )

        val startingLocation = GridCoord(aoc0424grid, 9,1)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 5
        neighbours shouldContainExactly expected
    }

    should("be able to generate list of (5) valid neighbours from the south of the grid"){
        val expected = listOf(
            Neighbour(GridCoord(aoc0424grid, 1,8), NORTH),
            Neighbour(GridCoord(aoc0424grid, 2,8), NE),
            Neighbour(GridCoord(aoc0424grid, 2,9), EAST),
            Neighbour(GridCoord(aoc0424grid, 0,9), WEST),
            Neighbour(GridCoord(aoc0424grid, 0,8), NW)
        )

        val startingLocation = GridCoord(aoc0424grid, 1,9)
        val neighbours = startingLocation.neighbours()
        neighbours.size shouldBe 5
        neighbours shouldContainExactly expected
    }

    should("retrieve a list of coords in a northerly direction"){
        val movingDirection = NORTH
        val vectorList = GridCoord(aoc0424grid, 9,9).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 9,9),
            GridCoord(aoc0424grid, 9,8),
            GridCoord(aoc0424grid, 9,7),
            GridCoord(aoc0424grid, 9,6)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        //TODO error cases
//        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,-1,0,11)
    }

    should("retrieve a list of coords in a north easterly direction"){
        val movingDirection = NE
        val vectorList = GridCoord(aoc0424grid, 3,9).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 3,9),
            GridCoord(aoc0424grid, 4,8),
            GridCoord(aoc0424grid, 5,7),
            GridCoord(aoc0424grid, 6,6)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        //TODO error cases
//        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,-1,0,11)
    }

    should("retrieve a list of coords in a easterly direction"){
        val movingDirection = EAST
        val vectorList = GridCoord(aoc0424grid, 5,0).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 5,0),
            GridCoord(aoc0424grid, 6,0),
            GridCoord(aoc0424grid, 7,0),
            GridCoord(aoc0424grid, 8,0)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        testInvalidVectoring(aoc0424grid, 0,0, movingDirection,10,10,0,11)
        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,1,10,0,2)
        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,19,0,11)

    }

    should("retrieve a list of coords in a south easterly direction"){
        val movingDirection = SE
        val vectorList = GridCoord(aoc0424grid, 4,0).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 4,0),
            GridCoord(aoc0424grid, 5,1),
            GridCoord(aoc0424grid, 6,2),
            GridCoord(aoc0424grid, 7,3)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        testInvalidVectoring(aoc0424grid, 0,0, movingDirection,20,20,20,21)
        testInvalidVectoring(aoc0424grid, 9,9, movingDirection,1,10,10,2)
        testInvalidVectoring(aoc0424grid, 5,9, movingDirection,1,6,10,2)
        testInvalidVectoring(aoc0424grid, 9,5, movingDirection,1,10,6,2)
    }

    should("retrieve a list of coords in a southerly direction"){
        val movingDirection = SOUTH
        val vectorList = GridCoord(aoc0424grid, 9,3).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 9,3),
            GridCoord(aoc0424grid, 9,4),
            GridCoord(aoc0424grid, 9,5),
            GridCoord(aoc0424grid, 9,6)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        testInvalidVectoring(aoc0424grid, 1,0, movingDirection,10,1,10,11)
        testInvalidVectoring(aoc0424grid, 1,9, movingDirection,1,1,10, 2)
        testInvalidVectoring(aoc0424grid, 1,9, movingDirection,3,1,12, 4)
    }

    should("retrieve a list of coords in a south westerly direction"){
        val movingDirection = SW
        val vectorList = GridCoord(aoc0424grid, 9,3).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 9,3),
            GridCoord(aoc0424grid, 8,4),
            GridCoord(aoc0424grid, 7,5),
            GridCoord(aoc0424grid, 6,6)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        //TODO error cases
//        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,-1,0,11)
    }

    should("retrieve a list of coords in a westerly direction"){
        val movingDirection = WEST
        val vectorList = GridCoord(aoc0424grid, 4,1).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 4,1),
            GridCoord(aoc0424grid, 3,1),
            GridCoord(aoc0424grid, 2,1),
            GridCoord(aoc0424grid, 1,1)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,-1,0,11)
        testInvalidVectoring(aoc0424grid, 0,0, movingDirection,1,-1,0, 2)
        testInvalidVectoring(aoc0424grid, 9,9, movingDirection,20,-11,9, 21)
    }

    should("retrieve a list of coords in a north westerly direction"){
        val movingDirection = NW
        val vectorList = GridCoord(aoc0424grid, 6,5).vector(movingDirection, 3)

        vectorList.size shouldBe 4
        vectorList shouldBeEqual listOf(
            GridCoord(aoc0424grid, 6,5),
            GridCoord(aoc0424grid, 5,4),
            GridCoord(aoc0424grid, 4,3),
            GridCoord(aoc0424grid, 3,2)
        )
        vectorList.map { c -> c.value() }.joinToString("") shouldBe "XMAS"

        //TODO error cases
//        testInvalidVectoring(aoc0424grid, 9,0, movingDirection,10,-1,0,11)
    }

})

private fun testInvalidVectoring(grid: List<List<String>>,
                                 startX: Int,
                                 startY: Int,
                                 direction: TwoDGridDirection,
                                 distance: Int,
                                 expX: Int,
                                 expY: Int,
                                 expectedSteps: Int) {
    try {
        val invalidLocation = GridCoord(grid, SimpleCoord(startX, startY)).vector(direction, distance)
        fail("Vector (${distance} steps ${direction}) to ${invalidLocation.last().location} retrieval expected to run off board, should be caught here.")
    } catch (e: IndexOutOfBoundsException) {
        val venturesOutsideBoard = GridCoord(grid, startX, startY).vector(direction, distance, true)
        venturesOutsideBoard.size shouldBe expectedSteps
        venturesOutsideBoard.last() shouldBe GridCoord(grid, expX, expY)
    }
}

private fun testInvalidMutation(grid: List<List<String>>,
                                startX: Int,
                                startY: Int,
                                direction: TwoDGridDirection,
                                expX: Int,
                                expY: Int) {
    try {
        val invalidLocation = GridCoord(grid, SimpleCoord(startX, startY)).mutate(direction)
        fail("Mutation ${invalidLocation.location} expected to run off board, should be caught here.")
    } catch (e: IndexOutOfBoundsException) {
        val endOutsideNorthOfBoard = GridCoord(grid, SimpleCoord(startX, startY)).mutate(direction, true)
        endOutsideNorthOfBoard shouldBe GridCoord(grid, SimpleCoord(expX, expY))
    }
}