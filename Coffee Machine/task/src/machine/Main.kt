package machine

import java.util.*



fun main() {

    val scanner = Scanner(System.`in`)
    val machine = CoffeeMachine
    machine.setup()
    while(machine.mode != CoffeeMachine.Mode.OFF) {
        val command = scanner.next()
        machine.entry(command)
    }

}

object CoffeeMachine {
    enum class Fill(val message: String) {
        WATER("Write how many ml of water you want to add:"),
        MILK("Write how many ml of milk you want to add:"),
        BEANS("Write how many grams of coffee beans you want to add:"),
        CUPS("Write how many disposable cups you want to add:")
    }
    enum class Mode(val lambda: (String) -> Unit, val message: String) {
        MENU({ arg -> chooseAction(arg) }, "Write action (buy, fill, take, remaining, exit):"),
        BUY({ arg -> buy(arg) }, "What do you want to buy? 1 - Espresso, 2 - Latte, 3 - Cappucino, back - to main menu:"),
        FILL({  arg -> fill(arg) }, ""),
        OFF({ Unit }, "Shutting Down");

    }
    enum class Drink(
            val index: Int, val water: Int, val milk: Int, val beans: Int,
            val cups: Int, val money: Int) {
        ESPRESSO(1, 250, 0, 16, 1, 4),
        LATTE(2, 350, 75, 20, 1, 7),
        CAPPUCCINO(3, 200, 100, 12, 1, 6)

    }
    var mode = Mode.MENU
        private set(value) {
            field = value
        }
    private var fillmode = Fill.WATER
    private var water = 400
    private var milk = 540
    private var beans = 120
    private var cups = 9
    private var money = 550
    fun setup() {
        mode = Mode.MENU
        fillmode = Fill.WATER
        println(mode.message)
    }

    fun entry(arg: String) {
        mode.lambda(arg)
        if (mode == Mode.FILL) {
            println(fillmode.message)
        } else { println(mode.message) }

    }

    private fun chooseAction(choice: String) {
        when(choice) {
            "remaining", "r"-> {printStatus(); return}
            "take", "t" -> {take(); return}
        }
        mode = when (choice) {
            "buy", "b" -> Mode.BUY
            "fill", "f" -> Mode.FILL
            "exit", "e" -> Mode.OFF
            else -> Mode.MENU
        }
        if (mode == Mode.MENU) println("Invalid Selection")

    }
    private fun printStatus() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("\$$money of money")
        println()
    }
    private fun buy(sChoice: String) {

        when (sChoice) {
            "back", "b" -> {mode = Mode.MENU; return}
            !in listOf("1", "2", "3", "e", "espresso", "l", "latte", "c", "cappuccino") -> {
                println("Invalid Choice")
                return
            }
        }
        val choice = when (sChoice) {
            "1", "espresso", "e" -> Drink.ESPRESSO
            "2", "latte", "l" -> Drink.LATTE
            else -> Drink.CAPPUCCINO
        }
        if (insufficient(choice)) {
            mode = Mode.MENU
            return
        }
        water -= choice.water
        milk -= choice.milk
        beans -= choice.beans
        cups -= choice.cups
        money += choice.money
        println("I have enough resources, making you a coffee!")
        println()
        mode = Mode.MENU
    }
    private fun insufficient(choice: Drink):Boolean {
        var missing = ""
        when {
            water <  choice.water -> missing = "water"
            milk < choice.milk -> missing = "milk"
            beans < choice.beans -> missing = "beans"
            cups < choice.cups -> missing = "cups"
        }
        if (missing == "") {
            return false
        }
        println("Sorry, not enough $missing!")
        println()
        return true
    }
    private fun fill(input: String) {
        var isInt = true
        try {
            val amount = input.toInt()
        } catch (e: NumberFormatException) {
            isInt = false
        }
        val amount = if (isInt) { input.toInt()} else {-1}
        if (amount !in 0..1_000_000) {
            println("invalid amount, must be between 0 and 1_000_000")
            return
        }
        when (fillmode) {
            Fill.WATER -> {water += amount; fillmode = Fill.MILK; return}
            Fill.MILK -> {milk += amount; fillmode = Fill.BEANS; return}
            Fill.BEANS -> {beans += amount; fillmode = Fill.CUPS; return}
            Fill.CUPS -> {cups += amount; fillmode = Fill.WATER; mode = Mode.MENU; return}
        }
    }
    private fun take() {
        println("I gave you \$$money")
        money = 0
        println()
        mode = Mode.MENU
    }
}


/*
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
}*/






