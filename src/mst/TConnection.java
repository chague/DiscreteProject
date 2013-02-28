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
	
	//returns node that does not call this method
	public TNode notMe(TNode in) {
		TNode ret = null;
		if(TNodeOne.equals(in)) 
			ret = TNodeTwo;
		else
			ret = TNodeOne;
		return ret;
	}
	
	public TNode isMe(TNode in) {
		TNode ret = null;
		if(TNodeOne.equals(in))
			ret = TNodeOne;
		else
			ret = TNodeTwo;
		return ret;
	}
}
