package tio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import mst.TConnection;
import mst.TTree;

public class TreeInput {

	public static TTree getTreeFromConsole() {
		TTree tree = new TTree();

		System.out
				.println("Please input connections in this tree in the following format:\n"
						+ ": Title-NumericalWeight-Title2 or a-2-b\nDo not add any spaces or numbers (other than the weight)."
						+ "\nType 'stop' when you are finished entering connections");

		Scanner scan = new Scanner(System.in);

		String input = "";
		while (!input.equalsIgnoreCase("stop")) {
			input = scan.nextLine();
			TConnection connect = ConnectionInput
					.getConnectionFromString(input);
			if (connect != null) {
				connect.getNodes().get(0).addConnection(connect);
				connect.getNodes().get(1).addConnection(connect);
				tree.addNodes(connect.getNodes());
			} else if(!input.equalsIgnoreCase("stop"))
				System.out.println("Please enter a valid connection");

		}

		return tree;
	}

	public static TTree getTreeFromFile() {
		TTree tree = new TTree();
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		File inFile = null;
		while (!done) {
			System.out
					.println("Please input a full file path for a .txt file\nex: c:/myFolder/myFile.txt");
			String input = scan.nextLine();

			try {
				inFile = new File(input);
				done = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			FileReader fr = new FileReader(inFile);
			scan = new Scanner(fr);
			String input = "";
			while (scan.hasNext()) {
				input = scan.nextLine();
				System.out.println("Tried Input: "+input);
				TConnection connect = ConnectionInput
						.getConnectionFromString(input);
				if (connect != null) {
					tree.addNodes(connect.getNodes());
				} else
					System.out
							.println("Error in Connection format, please verify every connection is on its own line in this format:\n"
									+ "a-2-b");

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tree;
	}

}
