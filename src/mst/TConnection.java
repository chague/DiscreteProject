package mst;

import java.util.ArrayList;
import java.util.List;

public class TConnection {

	private int weight;
	private TNode TNodeOne, TNodeTwo;
	
	public TConnection() {}
	
	public TConnection(TNode one, TNode two, int weight) {
		this.TNodeOne = one;
		this.TNodeOne = two;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public TNode getTNodeOne() {
		return TNodeOne;
	}

	public void setTNodeOne(TNode tNodeOne) {
		TNodeOne = tNodeOne;
	}

	public TNode getTNodeTwo() {
		return TNodeTwo;
	}

	public void setTNodeTwo(TNode tNodeTwo) {
		TNodeTwo = tNodeTwo;
	}
	
	//returns node that does not call this method
	public TNode notMe(TNode in) {
		TNode ret = null;
		if(TNodeOne.equals(in)) 
			ret = TNodeTwo;
		else
			ret = TNodeOne;
		return ret;
	}
	
	public List<TNode> getNodes() {
		List<TNode> n = new ArrayList<TNode>();
		n.add(TNodeOne);
		n.add(TNodeTwo);
		return n;
	}
	
	public TNode isMe(TNode in) {
		TNode ret = null;
		if(TNodeOne.equals(in))
			ret = TNodeOne;
		else
			ret = TNodeTwo;
		return ret;
	}
	
	public boolean matchesNodes(List<TNode> input) {
		boolean matches = true;
		for(TNode in : input)
			if(!this.getNodes().contains(in))
				matches = false;
		return matches;
	}
	
	@Override 
	public String toString() {
		return TNodeOne + "-"+this.weight
				+"-"+TNodeTwo;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean areEqual = true;
		if(o.getClass().equals(this.getClass())) {
			TConnection c = (TConnection)o;
			if(!c.matchesNodes(this.getNodes()) || !(c.weight == this.weight))
				areEqual = false;
		}else 
			areEqual = false;
		return areEqual;
	}
}
