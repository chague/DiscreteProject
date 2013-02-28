package lst;

import java.util.ArrayList;
import java.util.List;

import mst.TConnection;
import mst.TNode;
import mst.TTree;

public class PrimSolution {

	private TTree tree;

	public PrimSolution(TTree inputTree) {
		this.tree = inputTree;
	}

	public TTree getTree() {
		return tree;
	}

	public void setTree(TTree tree) {
		this.tree = tree;
	}

	public TTree solveTree() {
		TTree solution = new TTree();

		// Take a vertex (randomly)
		TNode first = tree.getNodes().get(0);
		solution.addNode(first);

		List<TNode> vertices = new ArrayList<TNode>();
		for (TConnection tc : first.getConnections()) {
			vertices.add(tc.notMe(first));
		}

		solution.addNodes(vertices);

		return buildSolution(solution, vertices);
	}

	public TTree buildSolution(TTree solution, List<TNode> vertices) {

		TConnection lowestConnection = new TConnection(null, null, 0);
		TNode lowestNode = null;

		for (TNode n : vertices) {
			for (TConnection c : n.getConnections()) {
				if (c.getWeight() <= lowestConnection.getWeight()) {
					lowestConnection = c;
					lowestNode = n;
				}
			}
		}

		solution.addNode(lowestNode);
		if (lowestNode.getConnections() != null) {
			for (TConnection n : lowestNode.getConnections()) {
				vertices.add(n.notMe(lowestNode));
			}
		}

		if (solution.getNodes().size() == tree.getNodes().size())
			return solution;
		else
			return buildSolution(solution, vertices);
	}

}
