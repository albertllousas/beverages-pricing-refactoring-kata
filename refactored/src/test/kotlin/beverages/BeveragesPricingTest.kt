package beverages

import beverages.BeverageType.COFFEE
import beverages.BeverageType.HOT_CHOCOLATE
import beverages.BeverageType.TEA
import beverages.Extra.CREAM
import beverages.Extra.MILK
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.number.IsCloseTo.closeTo
import org.junit.jupiter.api.Test

class BeveragesPricingTest {

    @Test
    fun `should compute coffee price`() {
        val coffee = Beverage(type = COFFEE)
        assertThat(coffee.price(), `is`(closeTo(1.20, 0.001)))
    }

    @Test
    fun `should compute tea price`() {
        val tea = Beverage(type = TEA)
        assertThat(tea.price(), `is`(closeTo(1.50, 0.001)))
    }

    @Test
    fun `should compute hot chocolate price`() {
        val hotChocolate = Beverage(type = HOT_CHOCOLATE)
        assertThat(hotChocolate.price(), `is`(closeTo(1.45, 0.001)))
    }

    @Test
    fun `should compute tea with milk price`() {
        val teaWithMilk = Beverage(type = TEA, extras = listOf(MILK))
        assertThat(teaWithMilk.price(), `is`(closeTo(1.60, 0.001)))
    }

    @Test
    fun `should compute coffee with milk price`() {
        val coffeeWithMilk = Beverage(type = COFFEE, extras = listOf(MILK))
        assertThat(coffeeWithMilk.price(), `is`(closeTo(1.30, 0.001)))
    }

    @Test
    fun `should compute coffee with milk and cream price`() {
        val coffeeWithMilkAndCream = Beverage(type = COFFEE, extras = listOf(MILK, CREAM))
        assertThat(coffeeWithMilkAndCream.price(), `is`(closeTo(1.45, 0.001)))
    }

    @Test
    fun `should compute hot chocolate with cream price`() {
        val hotChocolateWithCream = Beverage(type = HOT_CHOCOLATE, extras = listOf(CREAM))
        assertThat(hotChocolateWithCream.price(), `is`(closeTo(1.60, 0.001)))
    }
}