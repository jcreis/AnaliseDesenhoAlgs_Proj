
public class Population implements Comparable<Population> {

	private int posX, posY, wealth;


	public Population(int x, int y, int wealth){
		this.posX = x;
		this.posY = y;
		this.wealth = wealth;
	}

	int getWealth(){
		return wealth;
	}

	int getX(){
		return posX;
	}

	int getY(){
		return posY;
	}

	@Override
	public int compareTo(Population pop) {
			if(this.wealth < pop.getWealth())
				return -1;
			else if(this.wealth > pop.getWealth())
				return 1;
			else
				return 0;
	}


}
