public class IntSearchTree extends IntBinTree{
	public IntSearchTree(int value, IntSearchTree left, IntSearchTree right){
		this.value= value;
		this.left= left;
		this.right= right;
	}
	
	public IntSearchTree(int value){
		this.value= value;
		left= null;
		right= null;
	}
	
	
	public boolean search(int i){
		while(getCont() != i && this != null){
			if(i <= getCont()){
				this= this.getLeft();
			}else{
				this= this.getRight();
			}
		}
		if(this == null)
			return false;
		return true;
	}
	
	public void insert(int i){
		while(true){
			if(i <= getCont()){
				if(left != null){
					this= this.getLeft();
				}else{
					setLeft(new IntSearchTree(i));
				}
			}else{
				if(right != null){
					this= this.getRight();
				}else{
					setRight(new IntSearchTree(i));
				}
			}
		}
	}
	
}