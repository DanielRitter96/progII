import java.util.*;

public class Board{
	public GameObj[][] board;


	public Board(){
		board= new GameObj[8][8];
		for(int i= 0;  i < board.length; i++){
			for(int j= 0; j < board[0].length; j++){
				board[i][j]= new Colorless(i,j);
			}
		}
	  /*board[3][3]= Field.WHITE;
		board[3][4]= Field.BLACK;
		board[4][4]= Field.WHITE;
		board[4][3]= Field.BLACK;*/

		GameObj w1= new White(3,3);
		GameObj w2= new White(4,4);
		GameObj b1= new Black(3,4);
		GameObj b2= new Black(4,3);

		board[3][3]= w1;
		board[3][4]= b1;
		board[4][4]= w2;
		board[4][3]= b2;

		/*GameObj coinw1= new White(3,3,WHITE);
		GameObj coinw2= new White(4,4,WHITE);
		GameObj coinb1= new Black(3,4,BLACK);
		GameObj coinb2= new Black(4,3,BLACK);
		ObjList w= new ObjList(coinw1, null);
		w.add(coinw2);
		ObjList b= new OnjList(cointb1, null);
		b.add(coinb2);*/
	}

	public void printBoard(){
		System.out.print(" ");
		for(int i= 0; i < 8; i++){
			System.out.printf("|%c",('A' + i));
		}
		System.out.println("|");
		for(int i= 0; i < 8; i++){
			System.out.print(i + "|");
			for(int j= 0; j < 8;j++){

				switch(board[i][j].getType()){
					case EMPTY: System.out.print("_|"); break;
					case WHITE: System.out.print("O|"); break;
					case BLACK: System.out.print("X|"); break;
				}

			}
			System.out.println("");
		}
	}



	public int[] score(){
		int[] score= new int[2];
		int black= 0;
		int white= 0;

		for(int i= 0; i < board.length; i++){
			for(int j= 0; j < board[0].length; j++){
				if(board[i][j].getType() == Field.BLACK){
					black++;
				}else if(board[i][j].getType() == Field.WHITE){
					white++;
				}
			}
		}
		score[0]= black;
		score[1]= white;
		return score;

	}


	public GameObj getPos(int[] point){
		int x= point[0];
		int y= point[1];
		return board[x][y];
	}

	/*public boolean valid(int[] point, ObjList list){// vermutlich doch noch anders
		int x= point[0];
		int y= point[1];
		if(board[x][y] == Field.EMPTY){
			for(ObjList temp= list; temp != null; temp= temp.getNext()){

			}
		}
	}*/
	public boolean inBounds(int i, int j){
		return i >= 0 && i <= 7 && j >= 0 && j <= 7;
	}

	public ObjList scored(Field turn, Field toFlip , int[] point){//who is the one drawing | is there a more efficent way
		int i= point[0];
		int j= point[1];
		int[] valid= new int[8];//if valid remains 0 then it is not a vaild draw

		ObjList list= new ObjList(new Colorless(i,j),null, -1);// -1 flag to remove it later
		// is the set position in bounds??
		//runter

		for(;inBounds(i + 1,j) && board[i + 1][j].getType() == toFlip; i++){
			valid[0]++;// sum function?
			list.add(board[i + 1][j], 0);
		}
		if(!inBounds(i + 1,j) || board[i + 1][j].getType() != turn){
			valid[0]= 0;
			list.remove(0);//remove with SeqNum 0
		}
		i= point[0];
		j= point[1];

		//hoch
		for(;inBounds(i - 1,j) && board[i - 1][j].getType() == toFlip; i--){
			valid[1]++;// sum function?
			list.add(board[i - 1][j], 1);
		}
		if(!inBounds(i - 1,j) || board[i - 1][j].getType() != turn){
			valid[1]= 0;
			list.remove(1);//remove with SeqNum 1
		}
		i= point[0];
		j= point[1];

		//rechts
		for(;inBounds(i,j + 1) && board[i][j + 1].getType() == toFlip; j++){
			valid[2]++;// sum function?
			list.add(board[i][j + 1], 2);
		}
		if(!inBounds(i,j + 1) || board[i][j + 1].getType() != turn){
			valid[2]= 0;
			//System.out.println(2);
			list.remove(2);//remove with SeqNum 2
		}
		i= point[0];
		j= point[1];

		//links
		for(;inBounds(i,j - 1) && board[i][j - 1].getType() == toFlip; j--){
			valid[3]++;// sum function?
			list.add(board[i][j - 1], 3);
		}
		if(!inBounds(i,j - 1) || board[i][j - 1].getType() != turn){
			valid[3]= 0;
			//System.out.println(3);
			list.remove(3);//remove with SeqNum 3
		}
		i= point[0];
		j= point[1];

		//diag. rechts_unten
		for(;inBounds(i + 1,j + 1) && board[i + 1][j + 1].getType() == toFlip; i++, j++){
			valid[4]++;// sum function?
			list.add(board[i + 1][j + 1], 4);
		}
		if(!inBounds(i + 1,j + 1) || board[i + 1][j + 1].getType() != turn){
			valid[4]= 0;
			list.remove(4);//remove with SeqNum 4
		}
		i= point[0];
		j= point[1];

		//diag. links_hoch
		for(;inBounds(i - 1 ,j - 1) && board[i - 1][j - 1].getType() == toFlip; i--, j--){
			valid[5]++;// sum function?
			list.add(board[i - 1][j - 1], 5);
		}
		if(!inBounds(i - 1 ,j - 1) || board[i - 1][j - 1].getType() != turn){
			valid[5]= 0;
			list.remove(5);//remove with SeqNum 5
		}
		i= point[0];
		j= point[1];

		// diag. rechts_hoch
		for(;inBounds(i - 1,j + 1) && board[i - 1][j + 1].getType() == toFlip; i--, j++){
			valid[6]++;// sum function?
			list.add(board[i - 1][j + 1], 6);
		}
		if(!inBounds(i - 1,j + 1) || board[i - 1][j + 1].getType() != turn){

			valid[6]= 0;
			list.remove(6);//remove with SeqNum 6
			//System.out.println(6);
		}
		i= point[0];
		j= point[1];

		//diag. links_unten
		for(;inBounds(i + 1,j - 1) && board[i + 1][j - 1].getType() == toFlip; i++, j--){
			valid[7]++;// sum function?
			list.add(board[i + 1][j - 1], 7);
		}
		if(!inBounds(i + 1,j - 1) || board[i + 1][j - 1].getType() != turn){
			valid[7]= 0;
			list.remove(7);//remove with SeqNum 7
		}

		list.remove(-1);
		if(Arrays.stream(valid).sum() <= 0){
			return null; // not valid... other function has to deal with that
		}

		return list;
	}


	public void setPos(GameObj obj){
		board[obj.getPoint()[0]][obj.getPoint()[1]]= obj;
	}


	public boolean vacant(int[] point){
		return board[point[0]][point[1]].getType() == Field.EMPTY;
	}

}
