package br.com.infogomes.analysisfinancial.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtil {
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
}
