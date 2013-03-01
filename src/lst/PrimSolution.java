package lst;

import java.util.Map;

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

		tree.removeNode(first);

		return buildSolution(solution);
	}

	// private TConnection findConnection(Map<String, Integer> input) {
	// for(TNode n : tree.getNodes())
	// if(n.getConnections().entrySet().contains(input))
	// return n.getConnections().get(inpu)
	// }

	private TConnection getNextLowest(TTree solution) {
		TConnection ret = null;
		int lowest = Integer.MAX_VALUE;
		for (TNode n : solution.getNodes()) {
			Map<String, Integer> conns = n.getConnections();
			String lowestKey = n.lowestPath();
			if (!solution.hasNode(lowestKey) && conns.get(lowestKey) < lowest)
				ret = new TConnection(n, lowestKey);
		}
		return ret;
	}

	private TNode removeFromTree(String name) {
		TNode ret = null;
		for (TNode n : tree.getNodes())
			if (n.getTitle().equalsIgnoreCase(name)) {
				ret = n;
				tree.removeNode(ret);
			}
		return ret;
	}

	private TTree buildSolution(TTree solution) {
		if (this.tree.getNodes().size() > 1) {

			TConnection lowest = getNextLowest(solution);
			if (lowest != null) {
				String toRemove = lowest.getConnectionKey();
				TNode toAdd = removeFromTree(toRemove);
				solution.addNode(toAdd);
			}

			return buildSolution(solution);

		} else
			return solution;

	}

}
