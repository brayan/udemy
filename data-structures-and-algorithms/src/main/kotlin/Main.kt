import kotlin.system.measureTimeMillis

// Kotlin Examples: https://github.com/abdurakhmonoff/data-structures-and-algorithms-kotlin

// let's measure the performance of this function with Big O
fun findNemo(fishList: List<String>) {
    for (i in fishList.indices) {
        if (fishList[i] == "nemo") {
            println("Found NEMO!!!")
            return
        }
    }
}

fun logFirstFish(fishList: List<String>) {
    println(fishList[0])
}

fun logFirstTwoFish(fishList: List<String>) {
    println(fishList[0])
    println(fishList[1])
}

fun firstChallenge(input: List<String>): Int {
    var a = 10 // O(1)
    a = 50 + 30 // O(1)

    for (i in input) { // O(n)
        anotherFunction() // O(n)
        val myBoolean = true // O(n)
        a++ // O(n)
    }

    return a // O(1)

    // BIG O(3 + 4n), or O(n)
}

fun compressBoxesTwice(boxes: List<String>) {
    repeat(boxes.size) { println(boxes) } // O(n)
    repeat(boxes.size) { println(boxes) } // O(n)
    // O(2n) -> O(n)
}

fun compressBoxesTwice2(boxes: List<String>, boxes2: List<String>) {
    repeat(boxes.size) { println(boxes) } // O(n)
    repeat(boxes2.size) { println(boxes2) } // O(n)
    // O(n + n)
}

fun logAllPairsOfArray() {
    val myArray = arrayOf(1, 2, 3, 4, 5) // Space Complexity of O(1)
    repeat(myArray.size) { first ->
        repeat((myArray.size)) { second ->
            println("${myArray[first]}, ${myArray[second]}")
        }
    }
    // O(n * n) -> O(nˆ2)
}

fun listOfHiNTimes(n: Int): List<String> {
    val myList = mutableListOf<String>() // New list

    for (i in 0 until n) { // Loops
        myList.add(i, "Hi!")
    }

    return myList
}

fun logAllPairsOfArrayWithoutNestedLoops(currentIndex: Int) {
    val myArray = arrayOf(1, 2, 3, 4, 5)
    repeat(myArray.size) { index ->
        println("${myArray[currentIndex]}, ${myArray[index]}")
    }

    val next = currentIndex + 1
    if (myArray.size > next) {
        logAllPairsOfArrayWithoutNestedLoops(next)
    }
    // O(n * n) -> O(nˆ2) -> n to the power of two 
}

fun anotherFunction() {}

// Brute force solution: nested loop
// Nested loops are something we should avoid on an interview
// We can use hash tables to speed things up
fun containsCommonItem(array1: Array<String>, array2: Array<String>): Boolean {
    array1.forEach { first ->
        array2.forEach { second ->
            if (first == second) {
                return true
            }
        }
    }
    return false
    // O(a*b) -> Time Complexity
    // O(1) -> Space Complexity
}

fun containsCommonItem2(array1: Array<String>, array2: Array<String>): Boolean {
    // loop through first array and create object where properties === items in the array
    // loop through second array and check if item in second array exists on created object
    val map = hashMapOf<Any, Boolean>()

    array1.forEach { item ->
        if (map.containsKey(item).not()) {
            map[item] = true
        }
    }

    array2.forEach { item ->
        if (map.containsKey(item)) {
            return true
        }
    }

    return false

    // O(a + b) -> Time Complexity is better thant the previous
    // O(a) -> Space Complexity
    // More efficient in terms of time complexity but is heavier because of map
}

fun containsCommonItem3(array1: Array<String>, array2: Array<String>): Boolean {
    return array2.any { array1.contains(it) }
    // O(a + b) Time Complexity is better thant the previous
}

// 1, 2, 3, 9

fun hasSumOfTwoNumbersInTheArray(array: Array<Int>, sum: Int): Boolean {
    repeat(array.size) { i ->
        repeat(array.size) { j ->
            if (i != j && (array[i] + array[j] == sum)) {
                return true
            }
        }
    }
    return false
    // Time Complexity of O(nˆ2)
    // Space Complexity of O(1)
}


//val sumGoogle = 8
//val arrayGoogle1 = arrayOf(6, 2, 3, 9)
fun hasSumOfTwoNumbersInTheArray2(array: Array<Int>, sum: Int): Boolean {
    val complements = hashSetOf<Int>()
    array.forEach {
        if (complements.contains(it)) {
            return true
        }
        complements.add(sum - it)// 2
    }
    return false
    // Time Complexity of O()
    // Space Complexity of O()
}


fun main(args: Array<String>) {
    val fishList = listOf("dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt", "darla", "hank")
    val large = mutableListOf<String>()

    for (i in 0..100000) {
        large.add("nemo")
    }

    val timeInMillis = measureTimeMillis {
        findNemo(large)
    }

    println("timeMillis2: $timeInMillis")


    // O(1)
    logFirstFish(fishList)

    // O(2)
    logFirstTwoFish(fishList)

//    logAllPairsOfArray()
    logAllPairsOfArrayWithoutNestedLoops(0)

    val listOfHi = listOfHiNTimes(10) // O(n)
    println(listOfHi)

    val array1 = arrayOf("a", "b", "c", "x")
    val array2 = arrayOf("z", "y", "x")
    val result = containsCommonItem2(array1, array2)
    println("Contain common items? $result")


    // val
    val sumGoogle = 8
    val arrayGoogle1 = arrayOf(1, 2, 3, 9)
    val arrayGoogle2 = arrayOf(1, 2, 4, 4)

    val hasSum = hasSumOfTwoNumbersInTheArray(arrayGoogle1, sumGoogle)
    println(hasSum)

}
