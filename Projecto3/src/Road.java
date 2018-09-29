
public class Road {
	
	private int cityTo, length;
	
	public Road(int city, int l){
		this.cityTo = city;
		this.length = l;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public int getCity(){
		return this.cityTo;
	}
	
	public void updateLength(int aux){
		length = aux;
	}
	
	public boolean equals(Object anObject){
		
		if(anObject instanceof Road){
			Road r1 = (Road)anObject;
			if(r1.getCity() == this.cityTo){
				return true;
			}
			else
				return false;
		}
		else{
			return false;
		}
	}
}
