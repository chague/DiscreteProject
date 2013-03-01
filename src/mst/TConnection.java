package mst;

public class TConnection {
	
	private TNode node;
	private String connectionKey;
	
	public TConnection(TNode node, String connectionKey) {
		this.node = node;
		this.connectionKey = connectionKey;
	}

	public TNode getNode() {
		return node;
	}

	public void setNode(TNode node) {
		this.node = node;
	}

	public String getConnectionKey() {
		return connectionKey;
	}

	public void setConnectionKey(String connectionKey) {
		this.connectionKey = connectionKey;
	}
	
	
	
}
