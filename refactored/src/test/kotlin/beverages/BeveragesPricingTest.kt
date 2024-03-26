package beverages

import beverages.BeverageType.*
import beverages.Extra.*
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
        val coffeeWithMilk: Coffee = CoffeeWithMilk()
        assertThat(coffeeWithMilk.price(), `is`(closeTo(1.30, 0.001)))
    }

    @Test
    fun `should compute coffee with milk and cream price`() {
        val coffeeWithMilkAndCream: Coffee = CoffeeWithMilkAndCream()
        assertThat(coffeeWithMilkAndCream.price(), `is`(closeTo(1.45, 0.001)))
    }

    @Test
    fun `should compute hot chocolate with cream price`() {
        val hotChocolateWithCream = HotChocolateWithCream()
        assertThat(hotChocolateWithCream.price(), `is`(closeTo(1.60, 0.001)))
    }
}