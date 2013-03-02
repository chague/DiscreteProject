package tio;

import java.util.ArrayList;
import java.util.List;

import mst.TConnection;
import mst.TNode;

public class ConnectionInput {

	private final static String CONNECTION_PATTERN = "[A-Za-z]+-\\d+-[A-Za-z]+";
	
	public static List<TConnection> getConnectionFromString(String input) {
		List<TConnection> returnConnections = new ArrayList<TConnection>();
		TConnection connectionOne = null;
		TConnection connectionTwo = null;
		if(input.matches(CONNECTION_PATTERN)) {
			String[] parts = input.split("-");
			connectionOne = new TConnection();
			connectionTwo = new TConnection();
			if(parts != null && parts.length == 3) {
				
				TNode one = new TNode(parts[0]);
				connectionOne.setTNodeOne(one);
				
				try {
					int weight = Integer.parseInt(parts[1]);
					connectionOne.setWeight(weight);
					connectionTwo.setWeight(weight);
				}catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					connectionOne = null;
					connectionTwo = null;
				}
				
				TNode two = new TNode(parts[2]);
				connectionTwo.setTNodeOne(two);
				connectionTwo.setTNodeTwo(one.getTitle());
				connectionOne.setTNodeTwo(two.getTitle());
				
				one.addConnection(connectionOne);
				two.addConnection(connectionTwo);
				returnConnections.add(connectionOne);
				returnConnections.add(connectionTwo);
	
			}
		}
		
		return returnConnections;
	}
	
}
