package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.HOT_CHOCOLATE
import beverages.BeverageType.TEA

enum class BeverageType {
    COFFEE, TEA, HOT_CHOCOLATE
}

open class Beverage(val type: BeverageType? = null) {
    open fun price(): Double = when(type) {
        COFFEE -> 1.2
        TEA -> 1.50
        HOT_CHOCOLATE -> 1.45
        null -> TODO()
    }
}
