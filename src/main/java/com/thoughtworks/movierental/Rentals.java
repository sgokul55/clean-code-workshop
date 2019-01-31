package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental>{
	
	double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : this) {
			totalAmount += each.getAmount();
			;
		}
		return totalAmount;
	}

	int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : this) {
			frequentRenterPoints += each.calculateFrequentPoints(each);
		}
		return frequentRenterPoints;
	}

}
