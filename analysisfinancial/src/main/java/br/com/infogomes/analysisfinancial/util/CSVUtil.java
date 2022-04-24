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
import java.util.stream.Collectors;

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

	private static Transaction parseToTransaction(String[] fields) {
		String sourceBank = fields[0];
		String sourceAgency = fields[1];
		String sourceAccount = fields[2];
		String destinationBank = fields[3];
		String destinationAgency = fields[4];
		String destinationAccount = fields[5];

		BigDecimal value = fields[6].trim() != "" ? BigDecimal.valueOf(Double.valueOf(fields[6])) : null;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime dateTime = fields[7].trim() != "" ? LocalDateTime.parse(fields[7], formatter) : null;

		return new Transaction(sourceBank, sourceAgency, sourceAccount, destinationBank, destinationAgency,
				destinationAccount, value, dateTime);
	}

	public static List<Transaction> parseToListTransaction(InputStream inputStream) {

		try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {

			List<String[]> listArrayFields = csvReader.readAll();

			if (listArrayFields.size() <= 0)
				return new ArrayList<>();

			return listArrayFields.stream().map(fields -> parseToTransaction(fields)).collect(Collectors.toList());

		} catch (IOException | CsvException e) {
			throw new RuntimeException("Erro ao ler o arquivo!!");
		}

	}

}
