package com.rox.adventofcode


enum class TwoDGridDirection(val yOffset: Int, val xOffset: Int) {
    ANY(-99,-99),
    STATIC(0,0),
    NORTH(-1,0),
    NE(-1,+1),
    EAST(0,+1),
    SE(+1,+1),
    SOUTH(+1,0),
    SW(+1,-1),
    WEST(0,-1),
    NW(-1,-1);

    companion object {
        fun adjecency(): List<TwoDGridDirection> {
            return listOf(NORTH, NE, EAST, SE, SOUTH, SW, WEST, NW)
        }
    }

    override fun toString(): String {
        return this.name
    }
}

//XXX should this hold what it's a neighbour of?
data class Neighbour<CellType>(val cell: GridCoord<CellType>,
                               val direction: TwoDGridDirection){
    override fun toString(): String {
        return "$direction neighbour: $cell"
    }
}

data class GridCoord<CellType>(val grid: List<List<CellType>>,
                               val location: SimpleCoord) {

    constructor(grid: List<List<CellType>>, x: Int, y: Int) : this(grid, SimpleCoord(x,y))

    fun withinGrid() : Boolean =  location.x >= 0 && location.x < grid.size && location.y >= 0 && location.y < grid[0].size

    fun value(): CellType{
        return grid[location.y][location.x]
    }

    /**
     * Return a List of all direct Neighbours (N,NE,E,SE,S,SW,W,NW) of this GridCoord
     */
    fun neighbours(): List<Neighbour<CellType>> {
        return TwoDGridDirection.adjecency().map { direction ->
            Neighbour(mutate(direction, true), direction) //TODO catch exception instead of filtering
        }.filter { neighbour ->
            //Exclude those outside the grid
            neighbour.cell.location.y >= 0 && neighbour.cell.location.y < grid.size &&
                    neighbour.cell.location.x >= 0 && neighbour.cell.location.x < grid[0].size
        }
    }

    /**
     * Return a List of all GridCoords for count steps in the given TwoDGridDirection
     */
    fun vector(direction: TwoDGridDirection, count: Int, includeOffgrid: Boolean = false) = (0 until count).scan(this){ loc, _ -> loc.mutate(direction, includeOffgrid) }

    /**
     * Mutate this GridCoord in the desired TwoDGridDirection to create a new GridCoord for that location.
     *
     * E.g. get the coordinate that is north of this one
     */
    fun mutate(direction: TwoDGridDirection, includeOffgrid: Boolean = false): GridCoord<CellType>{
        val newX = location.x + direction.xOffset
        val newY = location.y + direction.yOffset
        if (!includeOffgrid) {
            if (newX < 0 || newX >= grid.size || newY < 0 || newY >= grid[0].size) {
                throw IndexOutOfBoundsException("New location $direction (${newX},${newY}) is out of bounds for grid ${grid.size}x${grid[0].size}")
            }
        }
        return GridCoord(grid, SimpleCoord(newX, newY))
    }

    override fun toString(): String {
        return "g${grid.size}x${grid[0].size}@${location}"
    }
}