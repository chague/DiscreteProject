package mst;

import java.util.List;

public class TNode {
	
	private String title;
	private List<TConnection> connections;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TNode(String title) {
		this.title = title;
	}

	public List<TConnection> getConnections() {
		return connections;
	}

	public void setConnections(List<TConnection> connections) {
		this.connections = connections;
	}
	
	public void addConnection(TConnection t) {
		if (t != null)
			connections.add(t);
	}


	public boolean equals(TNode o) {
		return o.getTitle().equals(this.title);
	}
	
}
