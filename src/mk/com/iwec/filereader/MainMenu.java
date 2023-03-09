package mk.com.iwec.filereader;

import java.util.Scanner;

public class MainMenu {
	public static Integer menu() {
		Scanner x = new Scanner(System.in);
		int input = 0;
		System.out.println("Please enter any number:");
		System.out.println("1) Read the CSV File.");
		System.out.println("2) Copy the file from one to another location?");
		System.out.println("3) Delete the existing fie");
		System.out.println("4) Get only Title");
		System.out.println("5) Quit");
		input = x.nextInt();
		x.close();
		return input;
	}
}
