package refactoring.price;

import refactoring.Movie;

/**
 * Created with IntelliJ IDEA.
 *
 * @author LogosFu
 * @since 2019/10/12 11:11 上午
 */
public class RegularPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int days) {
        return days > 2 ? (2 + (days - 2) * 1.5) : 2;
    }

    @Override
    public int getPoints(int days) {
        return 1;
    }
}
