
public class PositionNode {

	private int[] array = new int[4];
	private int result;
	public PositionNode(int x1, int y1, int x2, int y2, int result){
		array[0] = x1;
		array[1] = y1;
		array[2] = x2;
		array[3] = y2;
		this.result = result;
	}
	
	public int getX1(){
		return array[0];
	}
	public int getY1(){
		return array[1];
	}
	public int getX2(){
		return array[2]; 
	}
	public int getY2(){
		return array[3];
	}
	
	public int getCost(){
		return result;
	}
	
	public String getResult(){
		return this.result+"";
		
	}
}
