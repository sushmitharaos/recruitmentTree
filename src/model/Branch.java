package model;
import java.util.ArrayList;
import java.util.List;

public class Branch {
	List<Branch> branches;
	List<Fruit> fruits;

	public Branch(){
		this.branches = new ArrayList<Branch>();
		this.fruits = new ArrayList<Fruit>();
	}
	
	public Branch(int noOfSubBranches){
		this.branches = new ArrayList<Branch>();
		for (int i = 0; i < noOfSubBranches; i++) {
			branches.add(new Branch());
		}
	}

	public void addFruit(FruitType fruitType) {
		fruits.add(new Fruit(fruitType));
	}
	
	public void addBranch(Branch branch){
		this.branches.add(branch);
	}
	
	public void addFruitOnChildBranch(int branchNo, FruitType fruitType) {
		Branch branch = branches.get(branchNo - 1);
		branch.addFruit(fruitType);	
	}

	public void addBranchOnChildBranch(int branchNo, Branch subBranch) {
		Branch branch = branches.get(branchNo - 1);
		branch.addBranch(subBranch);
	}

	public int getNoOfFruits(FruitType fruitType) {
		int fruitCountInCurrentBranch = 0;
		if(hasFruits()){
			List<Fruit> fruitsOfRequiredType = new ArrayList<Fruit>();
			for (Fruit fruit : fruits) {
				if(fruit.fruitType == fruitType){
					fruitsOfRequiredType.add(fruit);
				}
			}
			fruitCountInCurrentBranch = fruitsOfRequiredType.size();
		}
		int fruitCountInChildBranches = 0;
		if(hasChildBranches()){
			for (Branch branch : branches) {
				fruitCountInChildBranches += branch.getNoOfFruits(fruitType);
			}
		}
		return fruitCountInCurrentBranch + fruitCountInChildBranches;
	}

	private boolean hasChildBranches() {
		return branches != null && branches.size() > 0;
	}

	private boolean hasFruits() {
		return fruits != null && fruits.size() > 0;
	}

	public int getFruitCount() {
		int fruitCountInCurrentBranch = 0;
		if(fruits != null && fruits.size() > 0){
			fruitCountInCurrentBranch = fruits.size();
		}
		
		int fruitCountInChildBranches = 0;
		if(branches != null && branches.size() > 0){
			for (Branch branch : branches) {
				fruitCountInChildBranches += branch.getFruitCount();
			}	
		}
		
		return fruitCountInCurrentBranch + fruitCountInChildBranches;
	}

	public boolean hasOnlyOranges() {
		if(fruits == null || fruits.size()==0){
			return false;
		}
		boolean currentBranchHasOnlyOranges = true;
		for (Fruit fruit : fruits) {
			if(fruit.fruitType == FruitType.APPLE){
				return false;
			}
		}
		
		boolean childBranchHadOnlyOrange = true;
		for (Branch branch : branches) {
			childBranchHadOnlyOrange = childBranchHadOnlyOrange && branch.hasOnlyOranges();
		}
		return currentBranchHasOnlyOranges && childBranchHadOnlyOrange; 
	}
}