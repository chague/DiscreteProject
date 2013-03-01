package mst;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class TNode {
	
	private String title;
	private Map<String, Integer> connections;
	
	public TNode() {
		connections = new HashMap<String, Integer>();
	}
	
	public TNode(String title) {
		this.title = title;
		connections = new HashMap<String, Integer>();
	}
	
	public boolean hasConnection(String in) {
		boolean conn = false;
		if(connections.containsKey(in))
			conn = true;
		
		return conn;
	}
	
	public String lowestPath() {
		String key = "";
		int lowest = Integer.MAX_VALUE;
		for(Entry<String, Integer> s : connections.entrySet()) {
			if(s.getValue() < lowest)
				key = s.getKey();
		}
		return key;
	}
	
	public void addConnection(Map<String, Integer> input){
		if(input != null) {
			connections.putAll(input);
		}
	}
	
	public Map<String, Integer> getConnections() {
		return connections;
	}

	public void setConnections(Map<String, Integer> connections) {
		this.connections = connections;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String input) {
		if(input != null && !input.isEmpty())
			this.title = input;
	}
	
	@Override
	public String toString() {
		return this.getTitle();
	}
	public boolean equals(TNode o) {
		return o.getTitle().equals(this.title);
	}
	
}
