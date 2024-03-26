package beverages

sealed interface BeverageType
data object Coffee : BeverageType
data object Tea : BeverageType
data object HotChocolate : BeverageType

sealed interface Supplement
data object Milk: Supplement
data object Cream: Supplement

open class Beverage(
    val type: BeverageType,
    val supplements: List<Supplement> = emptyList(),
    private val beveragePrices: Map<BeverageType, Double> = DEFAULT_BEVERAGE_PRICES,
    private val supplementPrices: Map<Supplement, Double> = DEFAULT_SUPPLEMENT_PRICES
) {

    companion object {
        val DEFAULT_BEVERAGE_PRICES: Map<BeverageType, Double> =
            mapOf(Coffee to 1.2, Tea to 1.50, HotChocolate to 1.45)
        val DEFAULT_SUPPLEMENT_PRICES: Map<Supplement, Double> =
            mapOf(Milk to 0.10, Cream to 0.15)
    }

    open fun price(): Double =
        (beveragePrices[type] ?: throw PriceNotPresentException(this.type.toString())) +
                supplements.sumOf { supplementPrices[it] ?: TODO() }
}

data class PriceNotPresentException(val item: String) : Exception("Price for $item is not present")
