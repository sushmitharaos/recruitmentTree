import model.*;

public class HelloWorld {
	
	public static ZyllemTree constructZyllemTree(){
		ZyllemTree recruitmentTree = new ZyllemTree(5);
		recruitmentTree.addFruitOnChildBranch(2, FruitType.APPLE);
		recruitmentTree.addFruitOnChildBranch(4, FruitType.ORANGE);
		recruitmentTree.addFruitOnChildBranch(4, FruitType.ORANGE);
		recruitmentTree.addFruitOnChildBranch(4, FruitType.ORANGE);
		
		Branch leafBranch = new Branch(2);
		leafBranch.addFruitOnChildBranch(1, FruitType.ORANGE);
		leafBranch.addFruitOnChildBranch(1, FruitType.ORANGE);
		leafBranch.addFruitOnChildBranch(1, FruitType.APPLE);
		leafBranch.addFruitOnChildBranch(2, FruitType.APPLE);
		
		Branch subBranch = new Branch(3);
		subBranch.addFruitOnChildBranch(1, FruitType.ORANGE);
		subBranch.addFruitOnChildBranch(3, FruitType.ORANGE);
		subBranch.addFruitOnChildBranch(3, FruitType.APPLE);
		subBranch.addBranchOnChildBranch(2, leafBranch);
		recruitmentTree.addBranch(5, subBranch);
		return recruitmentTree;
	}
	
	public static void main(String[] args){
		ZyllemTree recruitmentTree = constructZyllemTree();
		
		System.out.println("No of Oranges:");
		System.out.println(recruitmentTree.getNoOfFruits(FruitType.ORANGE));
		

		System.out.println("No of Apples:");
		System.out.println(recruitmentTree.getNoOfFruits(FruitType.APPLE));
		
		System.out.println("Branch with most Fruits");
		System.out.println(recruitmentTree.getBranchNoWithMostFruits());
		
		System.out.println("Branch with only oranges:");
		System.out.println(recruitmentTree.getBranchWithOnlyOranges());
	}
}
