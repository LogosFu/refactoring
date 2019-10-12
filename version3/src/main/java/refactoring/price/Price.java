package refactoring.price;

/**
 * Created with IntelliJ IDEA.
 *
 * @author LogosFu
 * @since 2019/10/12 10:30 上午
 */
public interface Price {
    public int getPriceCode();

    public double getCharge(int days);

    public int getPoints(int days);
}
