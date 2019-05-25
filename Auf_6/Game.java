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
				turn[0]= Integer.parseInt(black[0]);// if this does not work -> .toCharArray
				turn[1]= Character.valueOf(black[1]) - 'A';
				list= board.scored(Field.BLACK, Field.WHITE, turn);
				while(list == null){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");
					black= scanner.next();
					turn[0]= Integer.parseInt(black[0]);// if this does not work -> .toCharArray
					turn[1]= Character.valueOf(black[1]) - 'A';
					list= board.scored(Field.BLACK, Field.WHITE, turn);
				}
				board.setPos(new Black(turn[0], turn[1]));
				flip(list, Field.BLACK);
				board.printBoard();
				printScore(board.score());
				
				System.out.println("Turn of player O");
				white= scanner.next();
				turn[0]= Integer.parseInt(white[0]);// if this does not work -> .toCharArray
				turn[1]= Character.valueOf(white[1]) - 'A';
				list= board.scored(Field.WHITE, Field.BLACK, turn);
				while(list == null){
					System.out.println("Kein gültiger Zug!, Schau nochmal genau hin. ");
					white= scanner.next();
					turn[0]= Integer.parseInt(white[0]);// if this does not work -> .toCharArray
					turn[1]= Character.valueOf(white[1]) - 'A';
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
	
	
	
	
	public printScore(int[] score){
		System.out.println("Player X: " + score[0] + "Player O: " + score[1]);
	}
}