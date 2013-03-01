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

		tree.removeNode(first);

		return buildSolution(solution);
	}

	private TTree buildSolution(TTree solution) {
		if(this.tree.getNodes().size() > 0) {
			
			TConnection lowest = new TConnection(null, null, Integer.MAX_VALUE);
			for(TNode n : solution.getNodes())
				for(TConnection c : n.getConnections())
					if(solution.hasNode(c.getTNodeOne()) && tree.hasNode(c.getTNodeTwo()) && c.getWeight() < lowest.getWeight())
						lowest = c;
			
			solution.addNode(lowest.getTNodeTwo());
			tree.removeNode(lowest.getTNodeTwo());
			
			return buildSolution(solution);
			
		}else 
			return solution;
		
	}
	
	
}
