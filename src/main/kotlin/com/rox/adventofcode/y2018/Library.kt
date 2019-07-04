package com.rox.adventofcode.y2018

/**
 * Represents a 2D cartesian coordinate
 */
class Coordinate(val x: Int, val y: Int) {
    override fun toString(): String {
        return "${y}x$x"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Coordinate)
            return false

        if (other.x == x && other.y == y )
            return true

        return false
    }

    override fun hashCode(): Int {
        return 31 * x + y
    }
}