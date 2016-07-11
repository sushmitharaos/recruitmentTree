package model;
import java.util.ArrayList;
import java.util.List;


public class ZyllemTree {
		List<Branch> branches;
		
		public ZyllemTree(int noOfBranches){
			this.branches = new ArrayList<Branch>();
			for (int i = 0; i < noOfBranches; i++) {
				branches.add(new Branch());
			}
		}

		public void addFruit(int branchNo, FruitType fruitType) {
			Branch branch = branches.get(branchNo -1);
			branch.addFruit(fruitType);
		}

		public void addBranch(int branchNo, Branch subBranch) {
			Branch branch = branches.get(branchNo -1);
			branch.addBranch(subBranch);
		}

		public int getNoOfFruits(FruitType fruitType) {
			int noOfFruits = 0;
			for (Branch branch : branches) {
				noOfFruits += branch.getNoOfFruits(fruitType);
			}
			return noOfFruits;
		}

		public int getBranchNoWithMostFruits() {
			int maxfruitCount = 0;
			int maxFruitBranch = 0;
			for (int i = 0; i < branches.size(); i++) {
				Branch branch = branches.get(i);
				int branchFruitCount = branch.getFruitCount();
				if(maxfruitCount < branchFruitCount){
					maxfruitCount = branchFruitCount;
					maxFruitBranch = i+1;
				}
			}
			return maxFruitBranch;
		}

		public int getBranchWithOnlyOranges() {
			for (int i = 0; i < branches.size(); i++) {
				Branch branch = branches.get(i);
				if(branch.hasOnlyOranges()){
					return i+1;
				}
			}
			return 0;
		}
	}
	
