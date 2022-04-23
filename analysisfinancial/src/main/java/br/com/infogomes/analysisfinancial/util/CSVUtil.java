package br.com.infogomes.analysisfinancial.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import br.com.infogomes.analysisfinancial.entities.Transaction;

public abstract class CSVUtil {

	public static void readeCsv(InputStream inputStream) {
		try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {

			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				Arrays.asList(nextLine).stream().forEach(campo -> System.out.print(campo + " "));
				System.out.println();
			}
		} catch (IOException | CsvValidationException e) {
			// TODO: handle exception
		}
	}

	public static List<String[]> parseToTransactionList(InputStream inputStream) {

		List<String[]> transactions = new ArrayList<>();

		try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {

			String[] transactionLine;

			while ((transactionLine = csvReader.readNext()) != null) {
				transactions.add(transactionLine);
			}

		} catch (IOException | CsvValidationException e) {
			// TODO: handle exception
		}

		return transactions;
	}

	public static Transaction parseToTransaction(String[] fields) {
		String sourceBank = fields[0];
		String sourceAgency = fields[1];
		String sourceAccount = fields[2];
		String destinationBank = fields[3];
		String destinationAgency = fields[4];
		String destinationAccount = fields[5];

		BigDecimal value = BigDecimal.valueOf(Double.valueOf(fields[6]));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(fields[7], formatter);

		return new Transaction(sourceBank, sourceAgency, sourceAccount, destinationBank, destinationAgency,
				destinationAccount, value, dateTime);
	}

	public static boolean isEmpty(InputStream inputStream) {

		try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {
			
			return csvReader.readAll().size() <= 0;

		} catch (IOException | CsvException e) {
			// TODO: handle exception
		}

		return true;
	}
}
