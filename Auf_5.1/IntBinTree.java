//package de.uni_hannover.hci.daniel_ritter.bintree;

public abstract IntBinTree{
	public IntBinTree left;
	public int value;
	public IntBinTree right;

	/**
	Konstruktor für Binäre bäume, wobei midestens ein Kind mit angegeben werden kann.
	@param int - Der Wert im Baum.
	@param IntBinTree - Ein Kind
	@param IntBinTree - Ein Kind
	*/
	public IntBinTree(int value, IntBinTree left, IntBinTree right){
		this.value= value;
		this.left= left;
		this.right= right;
	}
	/**
	Konstruktor für Binäre bäume, wobei es sich um ein Blatt handelt.
	@param int - Der Wert im Baum.
	*/
	public IntBinTree(int value){//wenn man nur blätter hinzufügen will
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
	/**
	Der Inorder Durchlauf eines baums. -rekursive
	@return String - Der  besagte Durchlauf
	*/
	public String inOrder(){
		String s= "";
		if(left != null){
			s+= left.inOrder() + "";// Die Werte im linken Teilbaum als String konkatinieren
		}
		s+= getCont() + " "; // Die Werte tatsächlich konkatinieren
		if(right != null){
		    s+= right.inOrder() + "";// analog wie oben
		}
		return s;

	}
	
	/**
	Gibt den Baum als String in Inorder aus. Dabei werden Sonderzeichen hinzugefügt um klarer zu machen, wie genau die Struktur
	des Baumes ist. -rekursiv
	@return String - Der oben genannte String
	*/
	public String toString(){
		String s= "";
		if(left != null && right != null){
			s+= "(" + left.toString() + " " + getCont() + " " + right.toString() + ")";
		}else if(left != null){
			s+= "(" + left.toString() + " " + getCont() + " " + " _" + ")";
		}else if(right != null){
			s+= "(" + "_ " + " " +  getCont() + " " + right.toString() + ")";
		}else{
			s+= "(" + " " + getCont() + " "+ ")";
		}
		return s;
	}
	
	public abstract void insert(int i);
	
	public abstract boolean search(int i);
	

} 