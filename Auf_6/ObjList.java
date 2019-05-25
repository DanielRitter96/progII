public class ObjList{
	public GameObj element;
	public ObjList next;
	public int seqNum;

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
		for(ObjList temp= this; temp.getNext() != null; temp= temp.getNext()){
			temp.setNext(new ObjList(element, null));
		}
		
	}

	public void add(GameObj element, int SeqNum){
		for(ObjList temp= this; temp.getNext() != null; temp= temp.getNext()){
			temp.setNext(new ObjList(element, null, SeqNum));
		}
		
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
		if(this.getSeqNum() == seqNum){
			this= this.getNext();// if it does not work do it like beneaf
		}

		for(ObjList temp= this; temp.getNext() != null; temp= temp.getNext()){
			if(temp.getNext().getSeqNum() == seqNum){
				temp.setNext(temp.getNext().getNext());
			}
		}
	}

}
