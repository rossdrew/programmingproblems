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