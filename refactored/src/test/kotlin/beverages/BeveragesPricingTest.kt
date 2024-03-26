package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.HOT_CHOCOLATE
import beverages.BeverageType.TEA
import beverages.Extra.CREAM
import beverages.Extra.MILK
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.number.IsCloseTo.closeTo
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class BeveragesPricingTest {

    @TestFactory
    fun `beverage prices`() = listOf(
        Triple(Beverage(type = COFFEE), 1.20, 0.001),
        Triple(Beverage(type = TEA), 1.50, 0.001),
        Triple(Beverage(type = HOT_CHOCOLATE), 1.45, 0.001),
        Triple(Beverage(type = TEA, extras = listOf(MILK)), 1.60, 0.001),
        Triple(Beverage(type = COFFEE, extras = listOf(MILK)), 1.30, 0.001),
        Triple(Beverage(type = COFFEE, extras = listOf(MILK, CREAM)), 1.45, 0.001),
        Triple(Beverage(type = HOT_CHOCOLATE, extras = listOf(CREAM)), 1.60, 0.001),
        Triple(Beverage(type = COFFEE, beveragePrices = mapOf(COFFEE to 1.40)), 1.40, 0.001)
    ).map { (beverage, price, error) ->
        dynamicTest("should compute ${beverage.type} with extras ${beverage.extras}") {
            assertThat(beverage.price(), `is`(closeTo(price, error)))
        }
    }
}
