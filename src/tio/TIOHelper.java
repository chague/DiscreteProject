package tio;

import java.io.IOError;
import java.util.Scanner;

public class TIOHelper {

	// gets an int
	public static int getInt(String prompt) {
		int ret = 0;
		Scanner s = new Scanner(System.in);
		int input = -1;
		while (input == -1) {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(s.nextLine());
			} catch (IOError e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please input a valid positive integer");

			} finally {
				s.close();
				s = new Scanner(System.in);
			}
		}
		return ret;
	}
	
	public static String getString(String prompt) {
		String ret = null;
		Scanner s = new Scanner(System.in);
		while(ret == null) {
			System.out.println(prompt);
			ret = s.nextLine();
			if(ret.isEmpty())
				ret = null;
		}
		return ret;
	}
	
	

}
