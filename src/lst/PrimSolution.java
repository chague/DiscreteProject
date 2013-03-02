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
		

		// Take a vertex (randomly)
		TNode first = tree.getNodes().get(0);
		List<TNode> solution = new ArrayList<TNode>();
		solution.add(first);

		while (solution.size() < tree.getNodes().size()) {

			TConnection lowest = new TConnection(null, null, Integer.MAX_VALUE);
			
			for (TNode n : solution) {
				for (TConnection c : n.getConnections()) {
					TNode temp = new TNode(c.getTNodeTwo());
					
					boolean solHasNode = solution.contains(temp);
					boolean weightLower = c.getWeight() < lowest.getWeight();
					if (!solHasNode && weightLower) {
						lowest = c;
						solution.add(TNode.copyNode(findNodeByName(lowest.getTNodeTwo())));
					}
				}
			}

		}
		TTree solved = new TTree();
		solved.addNodes(solution);
		return solved;
		
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



}
