package beverages

import beverages.BeverageType.COFFEE

enum class BeverageType {
    COFFEE
}

open class Beverage(val type: BeverageType? = null) {
    open fun price(): Double = when(type) {
        COFFEE -> 1.2
        null -> TODO()
    }
}
