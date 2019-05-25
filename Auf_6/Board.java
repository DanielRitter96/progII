public class Board{
	public GameObj[][] board;
	
	
	public Board(){
		board= new GameObj[8][8];
		for(int i= 0;  i < board.length; i++){
			for(int j= 0 j < board[0].length; j++){
				board[i][j]= null;
			}
		}
		/*board[3][3]= Field.WHITE;
		board[3][4]= Field.BLACK;
		board[4][4]= Field.WHITE;
		board[4][3]= Field.BLACK;*/
		
		
		board[3][3]= new White(3,3,WHITE);
		board[3][4]= new Black(3,4,BLACK)
		board[4][4]= new White(4,4,WHITE);
		board[4][3]= new Black(4,3,BLACK);
		
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
		for(int i= 0; i < 8; i++){
			System.out.printf("|%c",('A' + i));
		}
		System.out.println("|");
		for(int i= 0; i < 8; i++){
			System.out.print(i + "|");
			for(int j= 0; j < 8;j++){
				if(board[i][j] == null){
					System.out.print("_|");
				}else{
					switch(board[i][j].getType()){
						case WHITE: System.out.print("O|"); break;
						case BLACK: System.out.print("X|"); break;
					}
				}
			}
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
				}else{
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
	public ObjList scored(Field turn, Field toFlip , int[] point){//who is the one drawing | is there a more efficent way 
		int i= point[0];
		int j= point[1];
		int[] valid= new int[8];//if valid remains 0 then it is not a vaild draw
		boolean free= board[point[0]][point[1]] == null; 
		ObjList list;
		
		//runter
		for(;free && board[i + 1][j].getType() == toFlip; i++){// out of bounce??
			valid[0]++;// sum function?
			list.add(board[i + 1][j], 0); 
		}
		if(board[i + 1][j] == null && board[i + 1][j].getType() != turn){
			valid[0]= 0;
			list.remove(0);//remove with SeqNum 0
		}
		i= point[0];
		j= point[1];
		
		//hoch
		for(;free && board[i - 1][j].getType() == toFlip; i--){// out of bounce??
			valid[1]++;// sum function?
			list.add(board[i - 1][j], 1); 
		}
		if(board[i - 1][j] == null && board[i - 1][j].getType() != turn){
			valid[1]= 0;
			list.remove(1);//remove with SeqNum 1
		}
		i= point[0];
		j= point[1];
		
		//rechts
		for(;free && board[i][j + 1].getType() == toFlip; j++){// out of bounce??
			valid[2]++;// sum function?
			list.add(board[i][j + 1], 2); 
		}
		if(board[i][j + 1] == null && board[i][j + 1].getType() != turn){
			valid[2]= 0;
			list.remove(2);//remove with SeqNum 2
		}
		i= point[0];
		j= point[1];
		
		//links
		for(;free && board[i][j - 1].getType() == toFlip; j--){// out of bounce??
			valid[3]++;// sum function?
			list.add(board[i][j - 1], 3); 
		}
		if(board[i][j - 1] == null && board[i][j - 1].getType() != turn){
			valid[3]= 0;
			list.remove(3);//remove with SeqNum 3
		}
		i= point[0];
		j= point[1];
		
		//diag. rechts_unten
		for(;free && board[i + 1][j + 1].getType() == toFlip; i++, j++){// out of bounce??
			valid[4]++;// sum function?
			list.add(board[i + 1][j + 1], 4); 
		}
		if(board[i + 1][j + 1] == null && board[i + 1][j + 1].getType() != turn){
			valid[4]= 0;
			list.remove(4);//remove with SeqNum 4
		}
		i= point[0];
		j= point[1];
		
		//diag. links_hoch
		for(;free && board[i - 1][j - 1].getType() == toFlip; i--, j--){// out of bounce??
			valid[5]++;// sum function?
			list.add(board[i - 1][j - 1], 5); 
		}
		if(board[i - 1][j - 1] == null && board[i - 1][j - 1].getType() != turn){
			valid[5]= 0;
			list.remove(5);//remove with SeqNum 5
		}
		i= point[0];
		j= point[1];
		
		// diag. rechts_hoch
		for(;free && board[i - 1][j + 1].getType() == toFlip; i--, j++){// out of bounce??
			valid[6]++;// sum function?
			list.add(board[i - 1][j + 1], 6); 
		}
		if(board[i - 1][j + 1] == null && board[i - 1][j + 1].getType() != turn){
			valid[6]= 0;
			list.remove(6);//remove with SeqNum 6
		}
		i= point[0];
		j= point[1];
		
		//diag. links_unten
		for(;free && board[i + 1][j - 1].getType() == toFlip; i++, j--){// out of bounce??
			valid[7]++;// sum function?
			list.add(board[i + 1][j - 1], 7); 
		}
		if(board[i + 1][j - 1] == null && board[i + 1][j - 1].getType() != turn){
			valid[7]= 0;
			list.remove(7);//remove with SeqNum 7
		}
		
		if(Arrays.stream(valid).sum() <= 0){
			return null; // not valid... other function has to deal with that
		}
		
		return list;
	}
	
	
	public void setPos(GameObj obj){
		board[obj.getPoint()[0]][obj.getPoint()[1]]= obj;
	}
	
	
	
		
}