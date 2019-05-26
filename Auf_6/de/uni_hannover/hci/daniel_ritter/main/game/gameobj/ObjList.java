package de.uni_hannover.hci.daniel_ritter.main.game.gameobj;

import de.uni_hannover.hci.daniel_ritter.main.game.gameobj.*;
import de.uni_hannover.hci.daniel_ritter.main.game.*;

public class ObjList{
	public GameObj element;
	public ObjList next;
	public int seqNum;

	public ObjList(){
		//does nothing really but i need it anyway
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

		}
		temp.setNext(new ObjList(element, null));

	}

	public void add(GameObj element, int SeqNum){
		ObjList temp= this;
		for(; temp.getNext() != null; temp= temp.getNext()){

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

	public void remove(int seqNum){
		/*if(this.getSeqNum() == seqNum){
			ObjList temp= this;
			temp= this.getNext();
		}*/
		// in java we have to check if the object actually exists before accessing any methods
		for(ObjList temp= this; temp != null && temp.getNext() != null; ){
			if((temp.getNext()).getSeqNum() == seqNum){

				temp.setNext((temp.getNext()).getNext());
				
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
