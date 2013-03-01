package mst;

import java.util.ArrayList;
import java.util.List;

public class TTree {

	private List<TNode> nodes;

	public TTree() {
		nodes = new ArrayList<TNode>();
	}

	public TTree(List<TNode> input) {
		this.nodes = input;
	}

	public List<TNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TNode> nodes) {
		this.nodes = nodes;
	}

	public void addNode(TNode toAdd) {
		if (toAdd != null)
			nodes.add(toAdd);
	}
	
	public void removeNode(TNode toRemove) {
		if(toRemove != null) 
			for(TNode n : nodes)
				if(n.equals(toRemove)) {
					nodes.remove(n);
					return;
				}
	}

	public void addNodes(List<TNode> toAdd) {
		if (toAdd != null) {
			for(TNode n : toAdd)
				if(!hasNode(n))
					nodes.add(n);
		}
	}

	public boolean hasNode(TNode in) {
		boolean hasNode = false;
		for (TNode node : this.nodes) {
			if (node.equals(in)) {
				hasNode = true;
				break;
			}
		}
		return hasNode;

	}

	@Override
	public String toString() {
		String ret = "";
		if (nodes != null && nodes.size() > 0) {
			StringBuilder sb = new StringBuilder();
			List<TConnection> printed = new ArrayList<TConnection>();
			for (TNode n : nodes) {
				for (TConnection c : n.getConnections()) {
					if(!printed.contains(c))
						printed.add(c);
				}
			}
			for(TConnection c : printed) {
				sb.append(c + "\n");
			}
			ret = sb.toString();
		} else
			ret = "Empty Tree";
		return ret;
	}
}
