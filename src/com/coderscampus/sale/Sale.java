package com.coderscampus.sale;

import java.time.YearMonth;

public class Sale {

	private YearMonth date;
	private int sales;

	public Sale(YearMonth date, int sales) {
		this.date = date;
		this.sales = sales;
	}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Sale [date=" + date + ", sales=" + sales + "]";
	}

}
