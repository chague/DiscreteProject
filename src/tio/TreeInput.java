package tio;

import java.util.Scanner;

import mst.TConnection;
import mst.TTree;

public class TreeInput {
	
	
	
	public static TTree getTreeFromConsole() {
		TTree tree = new TTree();
		
		System.out.println("Please input connections in this tree in the following format:\n"+
				": Title-NumericalWeight-Title2 or a-2-b\nDo not add any spaces or numbers (other than the weight)."+
				"\nType 'stop' when you are finished entering connections");
		
		Scanner scan = new Scanner(System.in);
		
		String input = "" ;
		while(!input.equalsIgnoreCase("stop")) {
			input = scan.nextLine();
			TConnection connect = ConnectionInput.getConnectionFromString(input);
			if(connect != null) {
				tree.addNodes(connect.getNodes());
			}else
				System.out.println("Please enter a valid connection");
			
		}
		
		return tree;
	}
	
}
