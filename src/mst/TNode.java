package mst;

import java.util.ArrayList;
import java.util.List;

public class TNode {
	
	private String title;
	private List<TConnection> connections;
	

	public TNode(String title) {
		this.title = title;
		connections = new ArrayList<TConnection>();
	}

	public List<TConnection> getConnections() {
		return connections;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setConnections(List<TConnection> connections) {
		this.connections = connections;
	}
	
	public void addConnection(TConnection t) {
		if (t != null)
			connections.add(t);
	}
	
	private void trimConnections() {
//		List<String> toEndPoints = new ArrayList<String>();
//		List<String> dups = new ArrayList<String>();
//		for(TConnection t : connections) {
//			if(toEndPoints.contains(t.getTNodeTwo()) &&
//					!dups.contains(t.getTNodeTwo())) {
//				dups.add(t.getTNodeTwo());
//			} else {
//				toEndPoints.add(t.getTNodeTwo());
//			}
//		}
//		
//		for(String s : dups) {
//			List<TConnection> toTrim = new ArrayList<TConnection>();
//			for(TConnection connect : connections) {
//				if(connect.getTNodeTwo().equals(s)) 
//					toTrim.add(connect);
//			}
//			if(toTrim.size() > 0) {
//				int min = toTrim.get(0).getWeight();
//				for(TConnection connect : toTrim) {
//					if(connect.getWeight() < min) 
//						min = connect.getWeight();
//				}
//			}
//		}
	}

	@Override
	public String toString() {
		return this.getTitle();
	}
	public boolean equals(TNode o) {
		return o.getTitle().equals(this.title);
	}
	
	public static TNode copyNode(TNode in) {
		TNode newNode = new TNode(in.getTitle());
		List<TConnection> connects = newNode.getConnections();
		for(TConnection c : connects) {
			newNode.addConnection(c);
		}
		
		return newNode;
	}
	
}
