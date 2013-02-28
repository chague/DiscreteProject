package tio;

import mst.TConnection;
import mst.TNode;

public class ConnectionInput {

	private final static String CONNECTION_PATTERN = "[A-Za-z]+-\\d+-[A-Za-z]+";
	
	public static TConnection getConnectionFromString(String input) {
		TConnection connection = null;
		if(input.matches(CONNECTION_PATTERN)) {
			String[] parts = input.split("-");
			connection = new TConnection();
			if(parts != null && parts.length == 3) {
				
				TNode one = new TNode(parts[0]);
				connection.setTNodeOne(one);
				
				try {
					int weight = Integer.parseInt(parts[1]);
					connection.setWeight(weight);
				}catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					connection = null;
				}
				
				TNode two = new TNode(parts[2]);
				connection.setTNodeTwo(two);
				
				one.addConnection(connection);
				two.addConnection(connection);
			}
		}
		return connection;
	}
	
}
