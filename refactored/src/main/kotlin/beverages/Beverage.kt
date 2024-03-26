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

open class Beverage(
    val type: BeverageType,
    val extras: List<Extra> = emptyList(),
    private val beveragePrices: Map<BeverageType, Double> = DEFAULT_BEVERAGE_PRICES,
    private val extraPrices: Map<Extra, Double> = DEFAULT_EXTRA_PRICES
) {

    companion object {
        val DEFAULT_BEVERAGE_PRICES: Map<BeverageType, Double> =
            mapOf(COFFEE to 1.2, TEA to 1.50, HOT_CHOCOLATE to 1.45)
        val DEFAULT_EXTRA_PRICES: Map<Extra, Double> =
            mapOf(MILK to 0.10, CREAM to 0.15)
    }

    open fun price(): Double = (beveragePrices[type] ?: TODO()) + extras.sumOf { extraPrices[it] ?: TODO() }
}
