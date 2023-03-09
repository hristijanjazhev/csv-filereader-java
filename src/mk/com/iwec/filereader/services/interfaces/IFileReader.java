package mk.com.iwec.filereader.services.interfaces;

import java.util.stream.Stream;

public interface IFileReader<T> {
	Stream<T> readCSV(String filePath);

	void copyTheFile(String originalFilePath);

	void quit();

	void deleteTheFile(String fileToDelete);

	void getOnlyTitle(String csvFile);

}
