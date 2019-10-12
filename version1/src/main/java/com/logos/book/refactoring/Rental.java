package com.logos.book.refactoring;

public class Rental {
	private Movie _movie; // 影片
	private int _daysRented; // 租期

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

    double getAmount() {
        double rentalAmount = 0;
        // determine amounts for each line
        switch (getMovie().getPriceCode()) { // 取得影片出租价格
        case Movie.REGULAR: // 普通片
            rentalAmount += 2;
            if (getDaysRented() > 2)
                rentalAmount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE: // 新片
            rentalAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS: // 儿童。
            rentalAmount += 1.5;
            if (getDaysRented() > 3)
                rentalAmount += (getDaysRented() - 3) * 1.5;
            break;
        }
        return rentalAmount;
    }

    int getFrequentRenterPoints() {
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
