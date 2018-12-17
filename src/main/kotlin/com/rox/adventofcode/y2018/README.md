# Advent of code 2018 - A Java Developers Kotlin Adventures

This is my first real forey into Kotlin.  The plan is to solve the problem as best I can then iterate over the solutions making them more idiomatic Kotlin.  Hopefully learning something as I go.


## Day 1

### Lesson 1 - Extensions

Part 2 required looping over a series of values, over and over until their sum reached a value which it had reached before.  So I solved it by creating a never ending loop:
```
    val deltas = inputA.split('\n').map { it.toInt() }
    var frequency = 0
    val frequencyHistory = mutableSetOf(0)
    var deltaIndex = 0

    while (true) {
        val delta = deltas[deltaIndex]
        frequency += delta

        if (frequencyHistory.contains(frequency))
            break

        frequencyHistory.add(frequency)

        if (++deltaIndex > deltas.size - 1) {
            deltaIndex = 0
        }
    }
```

but Kotlin has a nice feature, **extensions**.  I can extend an object, such as a `List<T>` and add a new method (`infiniteSequence()`) which provides a sequence that either yields all the entries or returns a new sequence of the entries.

### Lesson 2 - Scope Annotations

I can also call `this` or `return` based on specific scopes as defined by annotations

```
    fun <T> List<T>.infiniteSequence(): Sequence<T> = sequence {
        if (this@infiniteSequence.isEmpty()) {
            return@sequence
        }
        while (true) {
            yieldAll(this@infiniteSequence)
        }
    }
```

This all means the above piece of unmanageable code becomes an iteration over my infinite sequence.

```
    deltas.infiniteSequence().forEach { delta ->
        frequency+=delta
        if (frequencyHistory.contains(frequency))
            return frequency
        frequencyHistory.add(frequency)
    }
```

## Day 2

### Lesson 1 - Stream Manipulation

TODO

## Day 3

### Lesson 1 - Companion Objects

Kotlin has companion objects, which can do things such that in Java you would create a static factory method.  In this case useful for turning parsable lines into objects:

 ```
     fun parse(claimString: String): Claim =
           pattern.find(claimString)?.let { result ->
                val (id, x, y, length, height) = result.destructured
                Claim(id.toInt(), x.toInt(), y.toInt(), length.toInt(), height.toInt())
           } ?: throw IllegalArgumentException("Cannot parse $claimString")
 ```

### Lesson 2 - Ranges

Kotlins loop structure is made pretty using ranges, things like

```
   y in 0 until claim.height
   i in 0 to 100
```

but can even work in negatives such as

```
   y !in 0 until claim.height
```

which I find very expressive and handy

## Day 4

Trying to think more functionally, while still hanging on to Java OO for comfort.  My solution was essentially to compile an `Array` of minutes for each guard, in which they had slept.  Then it's just a matter of a `sum` on any guard to find out who slept the most and a `maxBy` to find out which minute was their most slept.

### Lesson 1 - Map function

I want to parse a whole bunch of lines into objects and sort them by one field (date time).  So I create a map of time->object from it.  The map function on List<String> is just a case of returning the phrase "key to value" so "entry.time to entry"

```
    logEntries.map { logEntry ->
      val entry = SleepLogEntry.parse(logEntry)
      entry.time to entry
    }
```

...very nice, then I can just `toMap` it and `toSortedMap` that.

### Lesson 2 - With Blocks

I didn't like creating that intermediate object so I had a look at the `with` block which allows us to do the parsing in it's argument and using a scope reference just return the result

```
    val sortedEntries = logEntries.map { logEntry ->
        with(SleepLogEntry.parse(logEntry)){
            return@map time to this
        }
    }.toMap()
     .toSortedMap()
```

### Lesson 3 - When blocks

There's some nice syntactic sugar to get rid of ugly scrolling `if objA == obj B` statements:

```
    return when {
      shiftStartPattern.matches(eventString) -> Event.CLOCK_ON
      eventString == "falls asleep" -> Event.SLEEP
      eventString == "wakes up" -> Event.WAKE
      else -> throw RuntimeException("Unexpected log entry format for '${eventString}'")
    }
```

### Lesson 4 - Collections maxBy()

_Not really something that will be new to people more familiar with functional style_.
I want to find the max value in a collection, but I want the location in the collection and not the value.

Given a map, I can have it calculate which is the max and return the key of the `Entry`
```
sleepSummaries.maxBy { it.value.sleepTally() }!!.key
```

or an array where the indice is the thing I'm calculating a max from
```
timeSheet.indices.maxBy { timeSheet[it] }!!
```

I guess I could have did it the same way with maps but it would require a double `!!` and be no clearer

```
sleepSummaries.keys.maxBy { sleepSummaries[it]!!.sleepTally() }!!
```

I can iterate over, providing a lambda which resolves a `Comparable` value from which a sensible "max" can be calculated.  I don't like that I need to "_Hold my beer_" (`!!`) these calls, when I know the value of the type but maybe I'm doing it wrong.