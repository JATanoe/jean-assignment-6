package com.coderscampus.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.sale.Sale;

public class FileService {

	private BufferedReader reader;
	private List<Sale> data;

	public List<Sale> read(String filename) throws IOException {

		try {
			this.reader = new BufferedReader(new FileReader(filename));
			this.data = new ArrayList<>();
			
			String headerLine = this.reader.readLine();
			String line;
			
			while ((line = this.reader.readLine()) != null) {
				String[] row = line.split(",");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
				
				YearMonth date = YearMonth.parse(row[0], formatter);
				Integer sales = Integer.parseInt(row[1]);

				this.data.add(new Sale( date, sales));
			}

			return this.data;

		} finally {
			if (this.reader != null)
				this.reader.close();
		}
	}

}
