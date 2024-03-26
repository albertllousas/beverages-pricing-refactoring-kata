package beverages

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.number.IsCloseTo.closeTo
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

class BeveragesPricingTest {

    @TestFactory
    fun `beverage prices`() = listOf(
        Triple(Beverage(type = Coffee), 1.20, 0.001),
        Triple(Beverage(type = Tea), 1.50, 0.001),
        Triple(Beverage(type = HotChocolate), 1.45, 0.001),
        Triple(Beverage(type = Tea, supplements = listOf(Milk)), 1.60, 0.001),
        Triple(Beverage(type = Coffee, supplements = listOf(Milk)), 1.30, 0.001),
        Triple(Beverage(type = Coffee, supplements = listOf(Milk, Cream)), 1.45, 0.001),
        Triple(Beverage(type = HotChocolate, supplements = listOf(Cream)), 1.60, 0.001),
        Triple(Beverage(type = Coffee, beveragePrices = mapOf(Coffee to 1.40)), 1.40, 0.001)
    ).map { (beverage, price, error) ->
        dynamicTest("should compute ${beverage.type} with extras ${beverage.supplements}") {
            assertThat(beverage.price(), `is`(closeTo(price, error)))
        }
    }

    @Test
    fun `should crash when beverage price is not present`() {
        assertThrows<PriceNotPresentException> { Beverage(type = Coffee, beveragePrices = emptyMap()).price() }
    }
}
