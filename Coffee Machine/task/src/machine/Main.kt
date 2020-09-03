package machine

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    requestSupplies()

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
    val water = cups * 200
    val milk = cups * 50
    val beans = cups * 15
    println("For $cups cups of coffee you will need:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
}