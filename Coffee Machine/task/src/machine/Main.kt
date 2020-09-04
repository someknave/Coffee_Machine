package machine

import java.util.*

val scanner = Scanner(System.`in`)
var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550
val supplies = mapOf<Int, IntArray>(1 to intArrayOf(250, 0, 16, 1, 4),
        2 to intArrayOf(350, 75, 20, 1, 7), 3 to intArrayOf(200, 100, 12, 1, 6))

fun main() {
    printStatus()
    chooseAction()
    printStatus()
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

fun printStatus() {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
    println()
    return
}

fun chooseAction() {
    print("Write action (buy, fill, take):")
    val choice = scanner.next()
    when (choice) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
        else -> println("Invalid action")
    }
    return
}

fun buy() {
    print("What do you want to buy? 1 - Espresso, 2 - Latte, 3 - Cappucino:")
    val choice = scanner.nextInt()
    if (choice !in 1..3) {
        println("Invalid choice")
        println()
        return
    }
    val coffeeReqs = supplies[choice]
    water -= coffeeReqs?.get(0)?:0
    milk -= coffeeReqs?.get(1)?:0
    beans -= coffeeReqs?.get(2)?:0
    cups -= coffeeReqs?.get(3)?:0
    money += coffeeReqs?.get(4)?:0
    println()
    return

}
fun fill() {
    print("Write how many ml of water you want to add:")
    water += scanner.nextInt()
    print("Write how many ml of milk you want to add:")
    milk += scanner.nextInt()
    print("Write how many grams of coffee beans you want to add:")
    beans += scanner.nextInt()
    print("Write how many disposable cups you want to add:")
    cups += scanner.nextInt()
    println()
    return
}
fun take() {
    println("I gave you \$$money")
    money = 0
    println()
    return
}