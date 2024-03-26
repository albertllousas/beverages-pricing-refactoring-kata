package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.HOT_CHOCOLATE
import beverages.BeverageType.TEA
import beverages.Extra.MILK

enum class BeverageType {
    COFFEE, TEA, HOT_CHOCOLATE
}

enum class Extra {
    MILK
}

open class Beverage(val type: BeverageType? = null, val extras: List<Extra> = emptyList()) {
    open fun price(): Double = when (type) {
        COFFEE -> 1.2
        TEA -> 1.50
        HOT_CHOCOLATE -> 1.45
        null -> TODO()
    } + extras.sumOf { extra ->
        when (extra) {
            MILK -> 0.10
        }
    }
}
