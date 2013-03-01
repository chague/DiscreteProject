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
	}
	
}
