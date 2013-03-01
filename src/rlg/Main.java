package rlg;

import lst.PrimSolution;
import mst.TTree;
import tio.TreeInput;


public class Main {
	
	public static void main(String[] args) {
		TTree input = TreeInput.getTreeFromConsole();
//		TTree input = TreeInput.getTreeFromFile();
		System.out.println(input);
		TTree output = new PrimSolution(input).solveTree();
		System.out.println("Got to end");
		System.out.println(output);
		
//		TNode nodeOne = new TNode("a");
//		TNode nodeTwo = new TNode("b");
//		TConnection one = new TConnection(nodeOne, nodeTwo, 2);
//		TConnection two = new TConnection(nodeOne, nodeTwo, 3);
//		
//		nodeOne.addConnection(one);
//		nodeTwo.addConnection(one);
//		nodeOne.addConnection(two); //here
//		nodeTwo.addConnection(two);
//		
//		System.out.println(one.equals(two));
	}
	
}
