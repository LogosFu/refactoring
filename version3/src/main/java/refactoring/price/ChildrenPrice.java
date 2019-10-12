package refactoring.price;

import refactoring.Movie;

/**
 * Created with IntelliJ IDEA.
 *
 * @author LogosFu
 * @since 2019/10/12 11:10 上午
 */
public class ChildrenPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int days) {

        return days > 3 ? 1.5 + (days - 3) * 1.5 : 1.5;
    }

    @Override
    public int getPoints(int days) {
        return 1;
    }


}
