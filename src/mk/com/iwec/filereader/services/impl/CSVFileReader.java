package mk.com.iwec.filereader.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import mk.com.iwec.filereader.services.interfaces.IFileReader;

public class CSVFileReader<T> implements IFileReader<Object> {

	public Stream<Object> readCSV(String filePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			Stream<String> lines = br.lines();

			Stream<String[]> values = lines.map(line -> line.split("!"));

			values.forEach(array -> {
				for (String value : array) {
					System.out.print(value + " ");
				}
				System.out.println();
			});
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Stream.empty();
	}

	public void copyTheFile(String originalFilePath) {
		String newCopiedFilePath = "C:\\Users\\hristijan\\Desktop\\work\\iw\\files\\fileReader-copy.csv";
		File copiedFile = new File(newCopiedFilePath);
		try (FileInputStream inputStream = new FileInputStream(originalFilePath);
				FileOutputStream outputStream = new FileOutputStream(copiedFile)) {

			inputStream.transferTo(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void quit() {
		System.exit(0);
	}

	@Override
	public void deleteTheFile(String fileToDelete) {
		File file = new File(fileToDelete);
		if (file.exists()) {
			file.delete();
			System.out.println("File was successfully deleted");
		} else {
			System.out.println("File not exist");
		}
	}

	public void getOnlyTitle(String csvFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.lines().skip(1).map(line -> line.split(",")).map(fields -> fields[0]).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
