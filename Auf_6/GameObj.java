public abstract class GameObj{
	public Field type;
	public int[] point;
	public GameObj(int x, int y){
		point[0]= x;
		point[1]= y;
	}
	
	public int[] getPoint(){// weiss nicht warum, aber warum nicht
		return point;
	}
	public void setType(Field type){// wenn der Spieler den gegner umdreht
		this.type= type;
	}
	
	public Field getType(){
		return type;
	}
}