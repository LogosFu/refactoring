package com.logos.book.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name; // 姓名
    private Vector _rentals = new Vector(); // 租借记

    public Customer(String name) {
        _name = name;
    }

    ;

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName();
        while (rentals.hasMoreElements()) {

            Rental rental = (Rental) rentals.nextElement(); // 取得一笔租借记。
            // add frequent renter points （累计常客积点。
            frequentRenterPoints += rental.getFrequentRenterPoints();
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getAmount());
            totalAmount += rental.getAmount();
        }
        // add footer lines（结尾打印）
        result += " Amount owed is " + String.valueOf(totalAmount);
        result += " You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

}
