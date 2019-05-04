public class WayPointList{
	
	public class WayPoint{
		private int x;
		private int y;
		
		private WayPoint next;
		public WayPoint(int x, int y){
			this.x= x;
			this.y= y;
			next= null;
		}
	}
	
	public WayPoint path;
	
	public void add(int x, int y){
		WayPoint wayPoint= new WayPoint(x, y);
		if(this.path == null){
			this.path= wayPoint;
		}else{
			for(WayPoint temp= this.path; temp.next != null; temp= temp.next){
				//runs to the end
			}
			temp.next= wayPoint;
		}
	}
	public int[] getFirstPos(){
		int[] pos= new int[2];
		pos[0]= path.WayPoint.x;
		pos[1]= path.WayPoint.y;
		return pos;
	}
	
	public int[] getLastPos(){
		int[] pos= new int[2];
		for(WayPointList temp= path; temp.next != null; temp= temp.next){
			//runs to the end
		}
		pos[0]= temp.WayPoint.x;
		pos[1]= temp.WayPoint.y;
		return pos;
	}
	
}