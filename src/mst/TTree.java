package mst;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		if (toRemove != null)
			for (TNode n : nodes)
				if (n.equals(toRemove)) {
					nodes.remove(n);
					return;
				}
	}

	public void addNodes(List<TNode> toAdd) {
		if (toAdd != null) {
			for (TNode n : toAdd) {
				if (!hasNode(n)) {
					nodes.add(n);
				} else {
					for (TNode node : nodes) {
						if (node.equals(n)) {
							node.addConnection(n.getConnections());
						}
					}
				}
			}

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

	public boolean hasNode(String in) {
		boolean hasNode = false;
		for (TNode node : this.nodes) {
			if (node.getTitle().equalsIgnoreCase(in))
				hasNode = true;
		}
		return hasNode;
	}

	private String reverseString(String input) {
		StringBuilder ret = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--) {
			ret.append(input.charAt(i));
		}
		return ret.toString();
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		List<String> toPrint = new ArrayList<String>();
		if (nodes != null && nodes.size() > 0) {
			for (TNode n : nodes) {
				if (n.getTitle() != null && !n.getTitle().isEmpty()) {
					String curr = n.getTitle() + "-";
					Map<String, Integer> conns = n.getConnections();
					for (String key : conns.keySet()) {
						curr += conns.get(key) + "-" + key;
						if (!toPrint.contains(reverseString(curr)))
							toPrint.add(curr);
					}
				}

			}

			for (String s : toPrint)
				ret.append(s + "\n");
		} else
			ret.append("Empty Tree");
		return ret.toString();
	}
}
