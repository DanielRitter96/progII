public class Maze{
	MazeEntry maze[][];
	int height;
	int width;
	//WayPointList solution;
	
	public Maze(String s){
		char[] mazeChar= s.toCharArray();
		this.height= mazeChar[2] - '0';
		this.width= mazeChar[0] - '0';
		this.maze= new MazeEntry[height][width]();
		int mazeIndexI= 0;
		int mazeIndexJ= 0;
		for(int i= 4; i < mazeChar.length; i++){
			
			switch(mazeChar[i]){
				case '#': this.maze[mazeIndexI][mazeIndexJ]= MazeEntry.WALL; 
						  mazeIndexJ++; break;
				case ' ': this.maze[mazeIndexI][mazeIndexJ]= MazeEntry.PATH;
						  mazeIndexJ++; break;
				case 'e': this.maze[mazeIndexI][mazeIndexJ]= MazeEntry.Entry;
						  mazeIndexJ++; break;
				case 'E': this.maze[mazeIndexI][mazeIndexJ]= MazeEntry.EXIT;
				
				default : mazeIndexI++; 
					      mazeIndexJ= 0; break; 
				
			}
		}
	}
	
	public void setPos(int x, int y, MazeEntry data){
		maze[x][y]= data;
	}
	public MazeEntry getPos(int x, int y){
		return maze[x][y];
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	
	public int[] getStart(){
		int[] pos= new int[2];
		pos[0]= 0;
		int i= 0
		while(maze[0][i] != MazeEntry.ENTRY){
			i++;
			//search for the entry wich is always at the top row
		}
		pos[1]= i;
		return pos;
	}
	
	public void print(){
		for(int i= 0; i < width; i++){
			for(int j= 0; j < height; j++){
				switch(MazeEntry){
					case WALL: System.out.printf("#"); break;
					case PATH: System.out.printf(" "); break;
					case ENTRY: System.out.printf("e"); break;
					case EXIT: System.out.printf("E"); break;
					case SOLUTION: Syste,.out.printf("-");break;
				}
			}
			System.out.printf("\n");
		}
	}
	
	public void setSolution(WayPointList path){
		int[] pos= new int[2];
		for(; path != null; path= path.next){
			pos= path.getFirstPos();
			maze[pos[0]][pos[1]]= MazeEntry.SOLUTION; 
		}
	}
}






