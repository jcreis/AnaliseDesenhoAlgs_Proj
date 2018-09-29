
public class Army implements Comparable<Army> {

	private int posX;
	private int posY;
	private int mainCost;


	public Army(int x, int y, int cost){
		this.posX = x;
		this.posY = y;
		this.mainCost = cost;

	}

	int getCost(){
		return mainCost;
	}

	int getX(){
		return posX;
	}

	int getY(){
		return posY;
	}

	@Override
	public int compareTo(Army o) {
		if(this.mainCost < o.getCost())
			return -1;
		else if(this.mainCost > o.getCost())
			return 1;
		else
			return 0;
}


}
