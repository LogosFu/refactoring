package refactoring;

import refactoring.price.ChildrenPrice;
import refactoring.price.NewReleasePrice;
import refactoring.price.Price;
import refactoring.price.RegularPrice;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return this.price.getPriceCode();
    }

    public String getTitle() {
        return title;
    }

    public void setPriceCode(int priceCode) {

        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getAmount(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int days) {
        // add bonus for a two day new release rental
        return price.getPoints(days);
    }
}