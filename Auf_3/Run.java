public class Run{
	public void solve(Maze maze){
		WayPointList path= new WayPointList();
		StackList stack= new StackList();
		int[] start= maze.getStart();
		int vertikal= start[0] + 1; // für hoch und runter bewegung
		int horizontal= start[1]; // für links und rechts bewegung
		path.add(vertikal, horizontal);
		
		if(maze[vertikal][horizontal - 1] == MazeEntry.PATH){// prüfen ob in liste
			path.add(vertikal, horizontal - 1);
			stack.push(path);
		}
		if(maze[vertikal][horizontal + 1] == MazeEntry.PATH){//siehe oben
			path.add(vertikal, horizontal + 1);
			stack.push(path);
		}
		if(maze[vertikal - 1][horizontal] == MazeEntry.PATH){//siehe oben
			path.add(vertikal - 1, horizontal);
			stack.push(path);
		}
		if(maze[vertikal + 1][horizontal] == MazeEntry.PATH){//siehe oben
			path.add(vertikal + 1, horizontal);
			stack.push(path);
		}
		
		int[] point= new int[2];
		
		while(true){
			point=(stack.pop()).getLastPos();
			int vertikal= point[0];
			int horizontal= point[1];
			if(maze[vertikal][horizontal] == MazeEntry.EXIT){
				break;
			}
			if(maze[vertikal][horizontal - 1] == MazeEntry.PATH || maze[vertikal][horizontal - 1] == MazeEntry.EXIT){// prüfen ob in liste
				path.add(vertikal, horizontal - 1);
				stack.push(path);
			}
			if(maze[vertikal][horizontal + 1] == MazeEntry.PATH || maze[vertikal][horizontal + 1] == MazeEntry.EXIT){//siehe oben
				path.add(vertikal, horizontal + 1);
				stack.push(path);
			}
			if(maze[vertikal - 1][horizontal] == MazeEntry.PATH || maze[vertikal - 1][horizontal] == MazeEntry.EXIT){//siehe oben
				path.add(vertikal - 1, horizontal);
				stack.push(path);
			}
			if(maze[vertikal + 1][horizontal] == MazeEntry.PATH || maze[vertikal + 1][horizontal] == MazeEntry.EXIT){//siehe oben
				path.add(vertikal + 1, horizontal);
				stack.push(path);
			}
		}
			// update vertikal & horizontal vllt der liste path die Koordinaten geben (mit setter und getter bei WayPointList) und jedesmal bei pop davon holne statt mit vertikal und horizontal				 
		}
	}
	public static void main(String[] args){
		
	}
}