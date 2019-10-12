package refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name; // 姓名
    private Vector<Rental> rentals = new Vector<>(); // 租借记

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement(); // 取得一笔租借记。
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + rental.getAmount();
        }
        // add footer lines（结尾打印）
        result += " Amount owed is " + getTotalCharge();
        result += " You earned " + getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        return rentals.stream().map(Rental::getAmount).reduce((double) 0, Double::sum);
    }

    private long getTotalFrequentRenterPoints() {
        return rentals.stream().map(Rental::getFrequentRenterPoints).reduce(0, Integer::sum);
    }
}
