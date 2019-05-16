//package de.uni_hannover.hci.daniel_ritter.bintree;
/**
Klasse für Suchbäume. Sie ist eine Unterklasse der binären Bäume.
@author daniel_ritter
*/
public class IntSearchTree extends IntBinTree{
	/**
	Der konstruktor, der identisch funktioniert wie die der Oberklasse.
	@param int - Der Wert im Baum.
	@param IntSearchTree - Ein Kind
	@param IntSearchTree - Ein Kind
	*/
	public IntSearchTree(int value, IntSearchTree left, IntSearchTree right){
		super(value, left, right);
	}
	/**
	Ein Weiterer Konstruktor, der identisch funktioniert wie der der Oberklasse.
	@param int - Der Wert im Baum.
	*/
	public IntSearchTree(int value){
		super(value);
	}



	/**
	Eine Containsfunktion für Suchbäume. Sie gibt true aus, wenn sich der Wert im Baum befindet. Dabei folgt sie der Struktur von Suchbäumen.
	-rekursiv
	@param int -Der gesuchte Werte
	@return boolean
	*/
	public boolean search(int i){
		if(i == getCont()){
			return true;
		}else if(i <= getCont()){// Wert befindet sich im linker Unterbaum
			if(left == null){
				return false;
			}else{
				return left.search(i);
			}
		}else{// Wert befindet sich im rechten Unterbaum
			if(right == null){
				return false;
			}else{
				return right.search(i);
			}
		}
	}
	/**
	Fügt den übergebenden Wert in den Baum ein. Dabei folgt er der Struktur von Suchbäumen.
	-rekursiv
	@param int -der Wert den man einfügen will
	*/
	public void insert(int i){
		if(i <= getCont()){// Wert mus in den linken Teilbaum
			if(left != null){
				left.insert(i);// suche im linken Teilbaum nach freier Stelle
			}else{
				setLeft(new IntSearchTree(i));
			}
		}else{// analog zu links
			if(right != null){
				right.insert(i);// analog zu links
			}else{
				setRight(new IntSearchTree(i));
			}
		}
	}
}
