public class StackList{
	public class StackElement{
		private WayPointList path;
		private StackElement next;
		
		public StackElement(WayPonitList path){
			this.path= path;
			next= null;
		}
	}
	
	public StackElement element;
	
	public void push(WayPonitList path){
		StackElement e= new StackElement(path);
		if(element == null){
			element= e;
		}else{
			e.next= element;
		}
	}
	
	public WayPointList pop(void){
		if(element == null){
			exit(0);
		}else{
			return element.path;
		}
	}
}