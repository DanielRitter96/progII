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
		this.seqNum;
	}
	
	public void add(GameObj element){
		ObjList(element, this.element);
	}
	
	public void add(GameObj element, int SeqNum){
		ObjList(element, this.element, SeqNum );
	}
	
	
	public GameObj getElement(){
		return element;
	}
	public ObjList getNext(){
		return next;
	}
	
	public int getSeqNum(){
		return SeqNum;
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