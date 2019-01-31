package com.thoughtworks.movierental;

public class Rental {

	private int daysRented;
	private Movie movie;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getAmount() {
		double amount = 0;
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			amount += 2;
			if (getDaysRented() > 2)
				amount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			amount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (getDaysRented() > 3)
				amount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return amount;
	}

	public int calculateFrequentPoints(Rental rental) {
		int frequentRenterPoints = 1;
		if (isBonusApplicable())
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private boolean isBonusApplicable() {
		return (movie.getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1;
	}

}