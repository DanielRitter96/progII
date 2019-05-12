public class IntBinTree{
	public IntBinTree left;
	public int value;
	public IntBinTree right;
	
	public IntBinTree(int value, IntBinTree left, IntBinTree right){
		this.value= value;
		this.left= left;
		this.right= right;
	}
	
	public IntBinTree(int value){
		this.value= value;
		left= null;
		right= null;
	}
	
	
	public IntBinTree getLeft(){
		return left;
	}
	
	public IntBinTree getRight(){
		return right;
	}
	
	public void setLeft(IntBinTree node){
		left= node;
	}
	
	public void setRight(IntBinTree node){
		right= node;
	}
	
	public int getCont(){
		return value;
	}
	
	public String inOrder(){
		String s;
		if(left != null){
			s= left.inOrder();// vllt +=
		}	
		s= getCont() + "";
		if(right != null){
			s= right.inOrder();
		}
	}
	
	public boolean search(int i){
		if(i == getCont()){
			return true;
		}
		
		if(left != null){
			return left.search(i);
		}
		
		if(right != null){
			return right.search(i);
		}
		
		return false;
	}
	
	public void insert(int i){
		int random= Random.nextInt(2);
		if(random == 0){
			if(left == null){
				setLeft(new IntBinTree(i));
			}else{
				left.insert(i);
			}
		}else{
			if(right == null){
				setRight(new IntBinTree(i));
			}else{
				right.insert(i);
			}
		}
	}
	
	public String toString(){
		String s;
		if(this == null){
			s= "_";//auch hier wieder vllt +=
		}else if(left != null || right != null){
			s= "(" + left.toString() + getCont() + right.toString() + ")";
		}else{
			s= "(" + getCont() + ")"; 
		}
	} 
	
}