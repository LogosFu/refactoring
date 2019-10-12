package refactoring.price;

import refactoring.Movie;

/**
 * Created with IntelliJ IDEA.
 *
 * @author LogosFu
 * @since 2019/10/12 11:12 上午
 */
public class NewReleasePrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int days) {
        return days* 3;
    }

    @Override
    public int getPoints(int days) {
        return days>1 ? 2:1;
    }
}
