package com.rox.adventofcode

import com.rox.adventofcode.TwoDGridDirection.*
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class TwoDGridDirectionTest : ShouldSpec({
    should("provide all cardinal directions"){
        TwoDGridDirection.adjecency() shouldBe listOf(NORTH, NE, EAST, SE, SOUTH, SW, WEST, NW)
    }
})