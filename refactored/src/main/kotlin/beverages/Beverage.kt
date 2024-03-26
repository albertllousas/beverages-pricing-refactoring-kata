package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.HOT_CHOCOLATE
import beverages.BeverageType.TEA
import beverages.Extra.CREAM
import beverages.Extra.MILK

enum class BeverageType {
    COFFEE, TEA, HOT_CHOCOLATE
}

enum class Extra {
    MILK, CREAM
}

open class Beverage(val type: BeverageType, val extras: List<Extra> = emptyList()) {
    open fun price(): Double = when (type) {
        COFFEE -> 1.2
        TEA -> 1.50
        HOT_CHOCOLATE -> 1.45
    } + extras.sumOf { extra ->
        when (extra) {
            MILK -> 0.10
            CREAM -> 0.15
        }
    }
}
