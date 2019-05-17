//package de.uni_hannover.hci.daniel_ritter;
//import de.uni_hannover.hci.daniel_ritter.bintree.*;


public class Main{
    public static void main(String[] args){
        IntRandTree tree1= new IntRandTree(10);
        IntSearchTree tree2= new IntSearchTree(10);
        tree1.insert(3);
        tree1.insert(6);
        tree1.insert(16);
        tree1.insert(32);
        tree1.insert(7);
        tree1.insert(54);
        tree1.insert(15);

        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(16);
        tree2.insert(32);
        tree2.insert(7);
        tree2.insert(54);
        tree2.insert(15);

        System.out.println(tree1.inOrder());
        System.out.println(tree2.inOrder());

        System.out.println(tree1.toString());
        System.out.println(tree2.toString());

        System.out.println(tree1.search(32));
        System.out.println(tree1.search(33));
        System.out.println(tree2.search(32));
        System.out.println(tree2.search(33));

        }

}
