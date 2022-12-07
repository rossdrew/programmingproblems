package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException
import java.util.*

private val inputSample = """
${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day7.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day7.input"))}")
}

/**
 *
 *
 * Answer: 1118405
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    var fileSystem = parseFileSystem(rows)
    val recursiveDirectoryListing = extractDirectories(fileSystem)
    //printDirectoryStructure(fileSystem)
    return recursiveDirectoryListing.map { dir -> dir.size() }.filter { size -> size <= 100000 }.sum()
}

/**
 *
 * Answer: 12545514
 */
private fun solutionB(input: String): Long? {
    val storageSpace =  70000000
    val requiredSpace = 30000000

    val rows = input.split('\n')
    var fileSystem = parseFileSystem(rows)
    val recursiveDirectoryListing = extractDirectories(fileSystem)

    val usedSpace = fileSystem.size()
    val remainingSpace = storageSpace - usedSpace
    val neededSpace = requiredSpace - remainingSpace

    return recursiveDirectoryListing
        .filter { dir -> dir.size() >= neededSpace }
        .sortedBy { dir -> dir.size() }
        .map { dir -> dir.size() }
        .min()
}

/** Debug function */
fun printDirectoryStructure(dir: Directory, nest: String = ""){
    println("$nest(+) ${dir.name()} (${dir.size()})${sizeIndicator(dir.size())}")
    dir.children.filter { !it.isLeaf() }.forEach { printDirectoryStructure(it as Directory, "$nest\t") }
    dir.children.filter { it.isLeaf() }.forEach { child -> println("$nest\t(-) ${child.name()} (${child.size()})") }
}

fun sizeIndicator(size: Long): String {
    return if (size <= 100000) "*" else ""
}

fun extractDirectories(directory: Directory): Set<Directory> {
    if (directory.children.none { child -> !child.isLeaf() })
        return setOf()

    return directory.children
        .filter { child -> !child.isLeaf() }
        .map { dir ->
            val directory = dir as Directory
            val dirs = mutableSetOf(directory)
            dirs.addAll(extractDirectories(directory))
            dirs
        }
        .flatten()
        .toSet()
}

private fun parseFileSystem(rows: List<String>): Directory {
    var fileSystem = Directory("/")

    val pwdStack = LinkedList<Directory>(listOf(fileSystem))

    rows.forEach { row ->
        when (row[0]) {
            //Command
            '$' -> when {
                //Change directory
                row.slice("$ ".length until row.length).startsWith("cd") -> {
                    when {
                        //Top of file system
                        row.slice("$ cd ".length until row.length).startsWith("/") -> {
                            pwdStack.clear()
                            pwdStack.add(fileSystem)
                        }

                        //backup
                        row.slice("$ cd ".length until row.length).startsWith("..") -> {
                            pwdStack.pop()
                        }

                        //directory
                        else -> {
                            val name = row.slice("$ cd ".length until row.length)

                            if (pwdStack.first.children.any{!it.isLeaf() && it.name() == name}){
                                val newDir = pwdStack.first.children.first{!it.isLeaf() && it.name() == name} as Directory
                                pwdStack.push(newDir)
                            }else{
                                throw UnexpectedException("Attempted to navigate to unknown directory '$name' from '${pwdStack.first.name}'")
                            }
                        }
                    }
                }

                //List director
                row.slice("$ ".length until row.length).startsWith("ls") -> {
                    //Do nothing and just assume the next few lines are files and directories
                }
            }

            //Directory Listing
            'd' -> {
                val name = row.slice("dir ".length until row.length)

                if (!pwdStack.first.children.any{child -> !child.isLeaf() && child.name() == name}){
                    pwdStack.first.addChild(Directory(name))
                }
            }

            //File Listing
            in '0'..'9' -> {
                val file = row.split(" ")
                              .zipWithNext { size, name -> Pair(name, Integer.parseInt(size).toLong())  }
                              .map { fileDecl -> File(fileDecl.first, fileDecl.second) }
                              .first()

                if (!pwdStack.first.children.any{it.isLeaf() && it.name() == file.name}){
                    pwdStack.first.addChild(file)
                }
            }
        }
    }
    return fileSystem
}

interface Node {
    /** The size of this an any sub Nodes */
    fun size(): Long
    /** The String name of this node */
    fun name(): String
    /** true if this is a leaf node (File) and false if not (Directory) */
    fun isLeaf(): Boolean
}

/**
 * A Node which represents a Directory that can contain other Nodes
 */
class Directory(val name: String) : Node {
    val children = mutableListOf<Node>()

    fun addChild(child: Node) = children.add(child)
    override fun size() = children.map { child -> child.size() }.sum()
    override fun name() = name
    override fun isLeaf() = false
}

/**
 * A Node which represents a File that cannot contain other Nodes
 */
class File(val name: String, val size: Long): Node {
    override fun size() = size
    override fun name() = name
    override fun isLeaf() = true
}


