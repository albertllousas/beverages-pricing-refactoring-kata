package beverages

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.number.IsCloseTo.closeTo
import org.junit.jupiter.api.Test

class BeveragesPricingTest {

    @Test
    fun computes_coffee_price() {
        val coffee: Beverage = Coffee()
        assertThat(coffee.price(), `is`(closeTo(1.20, 0.001)))
    }

    @Test
    fun computes_tea_price() {
        val tea: Beverage = Tea()
        assertThat(tea.price(), `is`(closeTo(1.50, 0.001)))
    }

    @Test
    fun computes_hot_chocolate_price() {
        val hotChocolate: Beverage = HotChocolate()
        assertThat(hotChocolate.price(), `is`(closeTo(1.45, 0.001)))
    }

    @Test
    fun computes_tea_with_milk_price() {
        val teaWithMilk: Tea = TeaWithMilk()
        assertThat(teaWithMilk.price(), `is`(closeTo(1.60, 0.001)))
    }

    @Test
    fun computes_coffee_with_milk_price() {
        val coffeeWithMilk: Coffee = CoffeeWithMilk()
        assertThat(coffeeWithMilk.price(), `is`(closeTo(1.30, 0.001)))
    }

    @Test
    fun computes_coffee_with_milk_and_cream_price() {
        val coffeeWithMilkAndCream: Coffee = CoffeeWithMilkAndCream()
        assertThat(coffeeWithMilkAndCream.price(), `is`(closeTo(1.45, 0.001)))
    }

    @Test
    fun computes_hot_chocolate_with_cream_price() {
        val hotChocolateWithCream = HotChocolateWithCream()
        assertThat(hotChocolateWithCream.price(), `is`(closeTo(1.60, 0.001)))
    }
}
