//package de.uni_hannover.hci.daniel_ritter.bintree;
import java.util.*;
/**
Klasse für algemeine binäre Bäume mit Integern.
@author Daniel Ritter
*/
public class IntRandTree extends IntBinTree{
	/**
	Konstruktor für Binäre bäume, wobei midestens ein Kind mit angegeben werden kann.
	@param int - Der Wert im Baum.
	@param IntBinTree - Ein Kind
	@param IntBinTree - Ein Kind
	*/
	public IntRandTree(int value, IntRandTree left, IntRandTree right){
		super(value, left, right);
	}
	/**
	Konstruktor für Binäre bäume, wobei es sich um ein Blatt handelt.
	@param int - Der Wert im Baum.
	*/
	public IntBinTree(int value){//wenn man nur blätter hinzufügen will
		super(value);
	}

	/**
	Eine Containsfunktion. Sie läuft rekursiv durch den kompletten Baum und gibt true aus wenn sich der Wert im Baum befindet.
	@param int - der gesuchte Werte
	@return boolean
	*/
	public boolean search(int i){
		boolean bool= false;
		if(i == getCont()){
			bool= true;
			return bool;
		}else{
			if(left != null){
				bool= left.search(i);
			}
			if(bool){// wenn sich der Wert im linken Baum befindet muss vorher beendet werden
				return bool;
			}
			if(right != null){
				bool= right.search(i);
			}

		}
		return bool;
	}
	/**
	Fügt den übergeben Wert in den baum ein, wobei zufällig entschieden wird welchen Einfügepfad gewählt wird. -rekursiv
	@param int - Der Wert der eingefügt weredn soll
	*/
	public void insert(int i){
		Random randomm= new Random();
		int random= randomm.nextInt(2);// Zufallszahl zwischen 0 und 1
		if(random == 0){// bei 0 nach links gehen
			if(left == null){
				setLeft(new IntBinTree(i));
			}else{
				left.insert(i);// suche im linken Teilbaum auf freie Stelle
			}
		}else{
			if(right == null){
				setRight(new IntBinTree(i));
			}else{
				right.insert(i);// analog zu links
			}
		}
	}
}
