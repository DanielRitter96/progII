import java.util.*;

public class Game{


	public void play(){
			Scanner scanner= new Scanner(System.in);
			String white= "";
			String black= "";
			int[] turn = new int[2];
			ObjList list;

			Board board= new Board();
			board.printBoard();
			printScore(board.score());

			int rounds= 0;
			while((white != "EOF" || black != "EOF") && rounds < 32){// scanner EOF??
				System.out.println("Turn of player X");
				black= scanner.next();
				char[] cblack= black.toCharArray();

				turn[0]= cblack[0] - '0';// if this does not work -> .toCharArray
				turn[1]= cblack[1] - 'A';

				list= board.scored(Field.BLACK, Field.WHITE, turn);
				while(list == null){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");
					black= scanner.next();
					cblack= black.toCharArray();
					turn[0]= cblack[0] - '0';// if this does not work -> .toCharArray
					turn[1]= cblack[1] - 'A';
					list= board.scored(Field.BLACK, Field.WHITE, turn);
				}
				board.setPos(new Black(turn[0], turn[1]));
				flip(list, Field.BLACK);
				board.printBoard();
				printScore(board.score());

				System.out.println("Turn of player O");
				white= scanner.next();
				char[] cwhite= white.toCharArray();

				turn[0]= cwhite[0] - '0';// if this does not work -> .toCharArray
				turn[1]= cwhite[1] - 'A';

				list= board.scored(Field.WHITE, Field.BLACK, turn);
				while(list == null){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");
					white= scanner.next();
					cwhite= white.toCharArray();

					turn[0]= cwhite[0] - '0';// if this does not work -> .toCharArray
					turn[1]= cwhite[1] - 'A';

					list= board.scored(Field.WHITE, Field.BLACK, turn);
				}
				board.setPos(new White(turn[0], turn[1]));
				flip(list, Field.WHITE);
				board.printBoard();
				printScore(board.score());

				rounds++;
			}



	}

	public void flip(ObjList list, Field toFlip){
		for(ObjList temp= list; temp != null; temp= temp.getNext()){
			temp.getElement().setType(toFlip);
		}
	}




	public void printScore(int[] score){
		System.out.println("Player X: " + score[0] + "Player O: " + score[1]);
	}
}
