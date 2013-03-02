package lst;

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

		// tree.removeNode(first);

		return buildSolution(solution);
	}

	private TNode findNodeByName(String name) {
		TNode ret = null;
		for (TNode n : tree.getNodes()) {
			if (n.getTitle().equalsIgnoreCase(name)) {
				ret = n;
				break;
			}
		}

		return ret;
	}

	private TTree buildSolution(TTree solution) {
		if (solution.getNodes().size() != tree.getNodes().size()) {

			TConnection lowest = new TConnection(null, null, Integer.MAX_VALUE);
			for (TNode n : solution.getNodes())
				for (TConnection c : n.getConnections())
					if (!solution.hasNode(c.getTNodeOne())
							&& tree.hasNode(c.getTNodeTwo())
							&& c.getWeight() < lowest.getWeight())
						lowest = c;

			solution.addNode(findNodeByName(lowest.getTNodeTwo()));

			return buildSolution(solution);

		} else
			return solution;

	}

}
