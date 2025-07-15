# Tesla Sales Report Generator

## Overview
This application analyzes and reports on Tesla vehicle sales data. It processes CSV files containing monthly sales figures for different Tesla models (Model 3, Model S, and Model X) and generates reports showing:

1. Yearly sales totals for each model
2. The best-selling month for each model
3. The worst-selling month for each model

## How to Use

1. Ensure you have Java installed on your system
2. Place the CSV files with sales data in the root directory:
   - `model3.csv` - Contains sales data for Tesla Model 3
   - `modelS.csv` - Contains sales data for Tesla Model S
   - `modelX.csv` - Contains sales data for Tesla Model X
3. Run the application using:
   ```
   java -cp bin com.coderscampus.Main
   ```

## CSV File Format
The application expects CSV files with the following format:
```
Date,Sales
Jul-17,30
Aug-17,75
...
```

Where:
- The first column (`Date`) is in the format `MMM-yy` (e.g., "Jul-17" for July 2017)
- The second column (`Sales`) is the number of vehicles sold in that month

## Project Structure

### Source Files
- `src/com/coderscampus/Main.java` - Entry point of the application
- `src/com/coderscampus/sale/Report.java` - Generates and displays sales reports
- `src/com/coderscampus/sale/Sale.java` - Data model for sales records
- `src/com/coderscampus/file/FileService.java` - Handles reading and parsing CSV files

### Data Files
- `model3.csv` - Sales data for Tesla Model 3
- `modelS.csv` - Sales data for Tesla Model S
- `modelX.csv` - Sales data for Tesla Model X

## Known Issues
- In the Report.java file, there's a bug where the best and worst month messages always refer to "Model 3" regardless of which model is being processed.

## Dependencies
- Java 8 or higher (uses Stream API and java.time package)
- No external libraries required