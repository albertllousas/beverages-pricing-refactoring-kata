package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.TEA

enum class BeverageType {
    COFFEE, TEA
}

open class Beverage(val type: BeverageType? = null) {
    open fun price(): Double = when(type) {
        COFFEE -> 1.2
        TEA -> 1.50
        null -> TODO()
    }
}
