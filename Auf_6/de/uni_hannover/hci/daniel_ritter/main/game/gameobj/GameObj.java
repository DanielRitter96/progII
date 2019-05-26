package de.uni_hannover.hci.daniel_ritter.main.game.gameobj;

import de.uni_hannover.hci.daniel_ritter.main.game.*;

public abstract class GameObj{
	public Field type;
	public int[] point;
	public GameObj(int x, int y, Field type ){
		this.point= new int[2];
		point[0]= x;
		point[1]= y;
		this.type= type;
	}

	public int[] getPoint(){// weiss nicht warum, aber warum nicht
		return point;
	}
	public void setType(Field type){// wenn der Spieler den Gegner umdreht
		this.type= type;
	}

	public Field getType(){
		return type;
	}
}
