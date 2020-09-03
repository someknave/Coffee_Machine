package machine

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    enoughSupplies()

}



fun makeCoffee() {
    println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!")
}

fun requestSupplies() {
    print("Write how many cups of coffee you will need:")
    val cups = scanner.nextInt()
    val supplies = cups.coffeeSupplies()
    println("For $cups cups of coffee you will need:")
    println("${supplies["water"]} ml of water")
    println("${supplies["milk"]} ml of milk")
    println("${supplies["beans"]} g of coffee beans")
}


fun enoughSupplies() {
    print("Write how many ml of water the coffee machine has:")
    val water = scanner.nextInt()
    print("Write how many ml of milk the coffee machine has:")
    val milk = scanner.nextInt()
    print("Write how many grams of coffee beans the coffee machine has:")
    val beans = scanner.nextInt()
    print("Write how many cups of coffee you will need:")
    val required = scanner.nextInt()
    val available = suppliesToCups(water, milk, beans)
    when {
        available == required -> println("Yes, I can make that amount of coffee")
        available < required -> println("No, I can only make $available cups of coffee")
        else -> println("Yes, I can make that amount of coffee (and even ${available - required} more than that)")
    }
}

fun Int.coffeeSupplies(): Map<String,Int> {
    return mapOf("water" to 200 * this,
            "milk" to 50 * this, "beans" to 15 * this)
}

fun suppliesToCups(water: Int, milk: Int, beans: Int): Int {
    val cups = minOf(water / 200, milk / 50, beans / 15)
    return cups
}