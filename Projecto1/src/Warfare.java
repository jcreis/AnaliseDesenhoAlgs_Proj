import java.util.Arrays;

public class Warfare {
	public Army[] armies;
	public Population[] populations;
	private int totalWealth;
	private int totalCosts;
	private int totalDistances;
	private int aCounter;
	private int pCounter;
//	private Atack[][] ataques;
	private int[][] distances;

	public Warfare(int numArmies, int numPopulation){
		armies = new Army[numArmies];
		populations = new Population[numPopulation];
		totalWealth = 0;
		totalCosts = 0;
		totalDistances = 0;
		aCounter = 0;
		pCounter = 0;
		distances = new int[armies.length][populations.length];
	}

	void addArmy(int x, int y, int cost){

		Army newArmy = new Army(x,y,cost);		

		armies[aCounter] = newArmy;
		aCounter++;
	}

//	void sortArmies(){
//
//		for(int i=0; i<armies.length; i++){
//			for(int j=0; j<armies.length-1; j++){
//				if(armies[j].getCost() > armies[j+1].getCost()){
//					Army aux = armies[j];
//					armies[j] = armies[j+1];
//					armies[j+1] = aux;
//				}
//			}
//		}
//				for(int k=0; k<armies.length;k++){
//					System.out.println(armies[k].getCost());
//				}
//	}

	void addPopulation(int x, int y, int wealth){

		Population newPop = new Population(x,y,wealth);

		populations[pCounter] = newPop;
		pCounter++;


	}

//	void sortPopulations(){
//
//		for(int i=0; i<populations.length; i++){
//			for(int j=0; j<populations.length-1; j++){
//				if(populations[j].getWealth() > populations[j+1].getWealth()){
//					Population aux = populations[j];
//					populations[j] = populations[j+1];
//					populations[j+1] = aux;
//				}
//			}
//		}
//				for(int k=0; k<populations.length;k++){
	//				System.out.println(populations[k].getWealth());
		//		}

	//}

	void calcResult(){

		Arrays.sort(armies);
		Arrays.sort(populations);
		fillDistanceMatrix();

		if(armies.length < populations.length){ // A < P
			
			int pop = populations.length - 1;
			
			for(int i=armies.length - 1; i>0; i--){

				atack(i,pop);
				pop--;
				
			}
		}

		else if(armies.length == populations.length){

			for(int i=0; i<armies.length; i++){

				atack(i,i);

			}

		}

		else{ // armies.lenght > pop.length
			
			
			int aux = 0;
			int popLeft = populations.length-1;
			
			for(int j = 0; j<populations.length; j++){
				int min = 0;
				int minArmy = 0;
				int i;

				for(i=aux; i<armies.length; i++){

					if(min == 0){
						min = distances[i][j];
						minArmy = i;
					}
					else if(distances[i][j] < min && i <= armies.length - popLeft){
						min = distances[i][j];
						minArmy = i;
						aux = i + 1;
					}

				}
				atack(minArmy,j);
				popLeft--;

			}
		}





	}

	void fillDistanceMatrix(){

		for(int i=0; i<armies.length; i++){

			for(int j=0; j<populations.length; j++){
				distances[i][j] = getDistance(armies[i], populations[j]);
			}

		}
	}

	void atack(int armyPos, int popPos){

		this.totalDistances += distances[armyPos][popPos];
		this.totalWealth += populations[popPos].getWealth(); // Add a riqueza daquela populacao
		this.totalCosts += armies[armyPos].getCost(); // Actualiza os custos totais de todos os exercitos usados

	}

	private int getDistance(Army a, Population p){
		return Math.abs(p.getX()-a.getX()) + Math.abs(p.getY()-a.getY());
	}

	int getWealth(){
		return totalWealth;
	}

	int getCosts(){
		return totalCosts;
	}

	int getDistances(){
		return totalDistances;
	}
}
