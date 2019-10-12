package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author LogosFu
 * @since 2019/10/11 9:52 下午
 */
class CustomerTest {

    @Test
    void statement() {
        Customer customer = new Customer("John");
        String title = "Titanic";
        int priceCode = 2;
        int _daysRented = 7;
        Movie movie = new Movie(title, priceCode);
        Rental rental = new Rental(movie, _daysRented);
        customer.addRental(rental);
        String result = customer.statement();
        assertEquals("Rental Record for John\tTitanic\t7.5 Amount owed is 7.5 You earned 1 frequent renter points",result);
    }
}