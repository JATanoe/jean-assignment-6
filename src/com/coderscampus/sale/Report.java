package com.coderscampus.sale;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.coderscampus.file.FileService;

public class Report {

	String[] files = {"model3.csv", "modelS.csv", "modelX.csv"};
	FileService service;

	public Report() {
		this.files = files;
		this.service = new FileService();
	}

	public void show() throws IOException {

		for (String filename : this.files) {

			List<Sale> model = this.service.read(filename);

			// Calculate yearly sales
			Map<Integer, Integer> yearlySales = model.stream().collect(
					Collectors.groupingBy(sale -> sale.getDate().getYear(), Collectors.summingInt(Sale::getSales)));

			// Print yearly sales report
			System.out.println(getModelName(filename) + " Yearly Sales Report" + "\n---------------------------");
			yearlySales.forEach((year, totalSales) -> System.out.println(year + " -> " + totalSales));

			// Print the best and worst months
			Sale bestMonthSales = model.stream().max(Comparator.comparing(Sale::getSales)).get();
			Sale worstMonthSales = model.stream().min(Comparator.comparing(Sale::getSales)).get();

			System.out.println();
			System.out.println("The best month for Model 3 was: " + bestMonthSales.getDate());
			System.out.println("The worst month for Model 3 was: " + worstMonthSales.getDate());
			System.out.println();

		}
	}

	private String getModelName(String filename) {
		String name = filename.replace(".csv", "");
		int size = name.length();

		String firstChar = name.substring(0, 1);
		String lastChar = name.substring(size - 1, size);
		name = name.replace(firstChar, firstChar.toUpperCase());
		name = name.replace(lastChar, " " + lastChar);

		return name;
	}

}
