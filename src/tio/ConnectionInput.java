package tio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mst.TNode;

public class ConnectionInput {

	private final static String CONNECTION_PATTERN = "[A-Za-z]+-\\d+-[A-Za-z]+";
	
	public static List<TNode> getConnectionFromString(String input) {
		List<TNode> nodes = new ArrayList<TNode>();
		if(input.matches(CONNECTION_PATTERN)) {
			String[] parts = input.split("-");
			if(parts != null && parts.length == 3) {
				
				TNode one = new TNode(parts[0]);
				int weight = 0;
				
				try {
					weight = Integer.parseInt(parts[1]);
				}catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				
				TNode two = new TNode(parts[2]);
				
				Map<String, Integer> mapOne = new HashMap<String, Integer>();
				mapOne.put(two.getTitle(), weight);
				
				Map<String, Integer> mapTwo = new HashMap<String, Integer>();
				mapTwo.put(one.getTitle(), weight);
				
				one.addConnection(mapOne);
				two.addConnection(mapTwo);
				
				nodes.add(one);
				nodes.add(two);
			}
		}
		return nodes;
	}
	
}
