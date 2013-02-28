package mst;

public class TConnection {

	private int weight;
	private TNode TNodeOne, TNodeTwo;
	
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
	
	
}
