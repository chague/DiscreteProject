package mst;

import java.util.List;

public class TTree {
	
	private List<TNode> nodes;
	
	public  TTree(List<TNode> input) {
		this.nodes = input;
	}

	public List<TNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TNode> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(TNode toAdd) {
		if(toAdd != null)
			nodes.add(toAdd);
	}
}
