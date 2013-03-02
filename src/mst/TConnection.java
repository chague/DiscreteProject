package mst;


public class TConnection {

	private int weight;
	private TNode TNodeOne;
	private String TNodeTwoTitle;
	
	public TConnection() {}
	
	public TConnection(TNode one, String two, int weight) {
		this.TNodeOne = one;
		this.TNodeTwoTitle = two;
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

	public String getTNodeTwo() {
		return TNodeTwoTitle;
	}

	public void setTNodeTwo(String in) {
		TNodeTwoTitle  = in;
	}
	
	//returns node that does not call this method
	public String notMe(TNode in) {
		String ret = "";
		if(TNodeOne.equals(in)) 
			ret = TNodeTwoTitle;
		else
			ret = TNodeOne.getTitle();
		return ret;
	}
	
//	public List<TNode> getNodes() {
//		List<TNode> n = new ArrayList<TNode>();
//		n.add(TNodeOne);
//		n.add(TNodeTwo);
//		return n;
//	}
	
	public TNode isMe(TNode in) {
		return TNodeOne;
	}
	
	@Override 
	public String toString() {
		return TNodeOne + "-"+this.weight
				+"-"+TNodeTwoTitle;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean areEqual = true;
		if(o.getClass().equals(this.getClass())) {
			TConnection c = (TConnection)o;
			areEqual = (c.getTNodeOne().equals(this.getTNodeOne()) &&
					c.getTNodeTwo().equals(this.getTNodeTwo()) &&
							c.getWeight() == this.weight);
		}else 
			areEqual = false;
		return areEqual;
	}
}
