public class ObjList{
	public GameObj element;
	public ObjList next;
	public int seqNum;

	public ObjList(){
		//this.element= null;
	//	this.next= null;
		//this.seqNum= -1;//the seqNum starts at the index 0
	}

	public ObjList(GameObj element, ObjList next){
		this.element= element;
		this.next= next;
	}

	public ObjList(GameObj element, ObjList next, int seqNum){
		this.element= element;
		this.next= next;
		this.seqNum= seqNum;
	}

	public void add(GameObj element){
		ObjList temp= this;
		for(; temp.getNext() != null; temp= temp.getNext()){
			//I'M SUCH AN IDIOT
		}
		temp.setNext(new ObjList(element, null));

	}

	public void add(GameObj element, int SeqNum){
		ObjList temp= this;
		for(; temp.getNext() != null; temp= temp.getNext()){
			//I'M SUCH AN IDIOT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		temp.setNext(new ObjList(element, null, SeqNum));


	}


	public GameObj getElement(){
		return element;
	}
	public ObjList getNext(){
		return next;
	}

	public int getSeqNum(){
		return seqNum;
	}

	public void setNext(ObjList next){
		this.next= next;
	}
	/*
	public void remove(int[] point){// vllt doch anders

	}
	*/
	public void remove(int seqNum){
		/*if(this.getSeqNum() == seqNum){
			ObjList temp= this;
			temp= this.getNext();
		}*/
		// in java we have to check if the object actually exists before accessing any methods
		for(ObjList temp= this; temp != null && temp.getNext() != null; ){
			if((temp.getNext()).getSeqNum() == seqNum){
				//ObjList toDelete= temp.getNext();
				temp.setNext((temp.getNext()).getNext());
				//toDelete= null;
				//temp= temp.getNext();
			}
			if(temp.getNext() != null && (temp.getNext()).getSeqNum() != seqNum){
				temp= temp.getNext();
			}
		}

	}

	public void printList(){
		for(ObjList temp= this; temp != null; temp= temp.getNext()){
			System.out.printf("%d\t",(temp.getElement()).getPoint()[0]);
		}
		System.out.println("");
	}

}
