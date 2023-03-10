package mk.com.iwec.filereader.menu;

import mk.com.iwec.filereader.MainMenu;
import mk.com.iwec.filereader.services.impl.CSVFileReader;

public class Menu {
	public static String csvPath = "src\\fileReader.csv";
	public static String fileToDelete = "src\\fileReader-copy.csv";

	public static void returnTheMenu() {
		CSVFileReader<?> fileReader = new CSVFileReader<Object>();
		Integer inputSelection;
		do {
			inputSelection = MainMenu.menu();
			switch (inputSelection) {
			case 1:
				fileReader.readCSV(csvPath);
				break;
			case 2:
				fileReader.copyTheFile(csvPath);
				break;
			case 3:
				fileReader.deleteTheFile(fileToDelete);
				break;
			case 4:
				fileReader.getOnlyTitle(csvPath);
				break;
			case 5:
				fileReader.quit();
			default:
				break;
			}
		} while (inputSelection > 5);
	}
}
