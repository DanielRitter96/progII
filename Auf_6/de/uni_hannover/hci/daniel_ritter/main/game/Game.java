package de.uni_hannover.hci.daniel_ritter.main.game;

import de.uni_hannover.hci.daniel_ritter.main.game.gameobj.*;
import de.uni_hannover.hci.daniel_ritter.main.game.board.*;
import de.uni_hannover.hci.daniel_ritter.main.game.gameobj.concrete.*;
import java.util.*;

public class Game{


	public void play(){
			Scanner scanner= new Scanner(System.in);
			String white= "";
			String black= "";
			int[] turn = new int[2];
			ObjList list= new ObjList();
			ObjList list2= new ObjList();



			Board board= new Board();
			board.printBoard();
			printScore(board.score());

			//System.out.println("Turn of player X");
			int rounds= 0;
			System.out.println("Runde: " + (rounds + 1));

			while(rounds < 32){// scanner EOF??


				System.out.println("Turn of player X");

				if(!scanner.hasNext()){
					break;
				}

				black= scanner.next();



				char[] cblack= black.toCharArray();

				turn[0]= cblack[0] - '0';
				turn[1]= cblack[1] - 'A';


				list= board.scored(Field.BLACK, Field.WHITE, turn);

				while(list == null || !board.vacant(turn)){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");

					if(!scanner.hasNext()){
						break;
					}

					black= scanner.next();



					cblack= black.toCharArray();
					turn[0]= cblack[0] - '0';
					turn[1]= cblack[1] - 'A';
					list= board.scored(Field.BLACK, Field.WHITE, turn);
				}


				board.setPos(new Black(turn[0], turn[1]));
				flip(list, Field.BLACK);
				board.printBoard();
				printScore(board.score());



				System.out.println("Turn of player O");

				if(!scanner.hasNext()){
					break;
				}

				white= scanner.next();


				char[] cwhite= white.toCharArray();

				turn[0]= cwhite[0] - '0';
				turn[1]= cwhite[1] - 'A';

				list2= board.scored(Field.WHITE, Field.BLACK, turn);

				while(list2 == null || !board.vacant(turn)){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");

					if(!scanner.hasNext()){
						break;
					}

					white= scanner.next();



					cwhite= white.toCharArray();

					turn[0]= cwhite[0] - '0';
					turn[1]= cwhite[1] - 'A';

					list2= board.scored(Field.WHITE, Field.BLACK, turn);
				}


				board.setPos(new White(turn[0], turn[1]));
				flip(list2, Field.WHITE);

				board.printBoard();
				printScore(board.score());


				rounds++;
				System.out.println("Runde: " + (rounds + 1));
			}

			System.out.println("Endstand:");
			printScore(board.score());




	}


	public void flip(ObjList list, Field toFlip){
		for(ObjList temp= list; temp != null; temp= temp.getNext()){
			(temp.getElement()).setType(toFlip);
		}
	}



	public void printScore(int[] score){
		System.out.println("Player X: " + score[0] + "  Player O: " + score[1]);
	}
}
