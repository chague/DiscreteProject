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
		if (t != null) {
			if(connections.size() > 0) {
				for(TConnection c : connections) {
					if(!c.equals(t)) {
						connections.add(t);
					}
				}
			}else
				connections.add(t);
		}
							
	}

	@Override
	public String toString() {
		return this.getTitle();
	}
	public boolean equals(TNode o) {
		return o.getTitle().equals(this.title);
	}
	
}
