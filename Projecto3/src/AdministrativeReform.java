import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AdministrativeReform {

	private List<Road> [] outEdges;


	private int[] length1;
	private int[] length2;

	private int capital1;
	private int capital2;

	private int cap1Counter;
	private int cap2Counter;
	private int cap1or2Counter;

	private int nComunities;


	@SuppressWarnings("unchecked")
	public AdministrativeReform(int nCom) {

		this.nComunities = nCom;

		cap1Counter = 0;
		cap2Counter = 0;
		cap1or2Counter = 0;

		length1 = new int[nComunities];

		length2 = new int[nComunities];

		outEdges = new List[nComunities];

	}

	public void createRoad(int city1, int city2, int length) {
		if(outEdges[city1] == null){
			outEdges[city1] = new LinkedList<Road>();
		}
		if(outEdges[city2] == null){
			outEdges[city2] = new LinkedList<Road>();
		}
		Road r1 = new Road(city2, length);
		Road r2 = new Road(city1, length);
		outEdges[city1].add(r1);
		outEdges[city2].add(r2);
	}

	public void setCapitals(int cap1, int cap2) {
		this.capital1 = cap1;
		this.capital2 = cap2;
	}


	public void calcResult() {

		PriorityQueue<Road> q;
		q = new PriorityQueue<Road>(new Comparator<Road>(){

			@Override
			public int compare(Road r1, Road r2) {

				if(r1.getLength() < r2.getLength()){
					return -1;
				}
				if(r1.getLength() > r2.getLength()){
					return 1;
				}
				else {
					return 0;
				}
			}

		});


		for(int j=0; j<nComunities; j++){
			length1[j] = Integer.MAX_VALUE;
		}
		for(int k=0; k<nComunities; k++){
			length2[k] = Integer.MAX_VALUE;
		}

		boolean[] selected;
		selected = new boolean[nComunities];

		length1[capital1] = 0;
		Road origin = new Road(capital1, 0);
		q.add(origin);

		while(!q.isEmpty()){
			Road firstRoad = q.poll();
			int firstCity = firstRoad.getCity();
			selected[firstCity] = true;

			Iterator<Road> it = outEdges[firstCity].iterator();
			while(it.hasNext()){
				Road itNextRoad = it.next();
				int itNextCity = itNextRoad.getCity();

				if(!selected[itNextCity]){
					int newLength = length1[firstCity] + itNextRoad.getLength();

					if(newLength < length1[itNextCity]){
						boolean inQueue = (length1[itNextCity] < Integer.MAX_VALUE);
						length1[itNextCity] = newLength;

						if(inQueue){

							Road newRoad = new Road(itNextCity, length1[itNextCity]);
							q.remove(newRoad);
							newRoad.updateLength(newLength);
							q.add(newRoad);					

						}
						else{
							Road newRoad = new Road(itNextCity, newLength);
							q.add(newRoad);
						}
					}
				}
			}
		}					

		selected = new boolean[nComunities];

		length2[capital2] = 0;
		Road origin2 = new Road(capital2,0);
		q.add(origin2);


		while(!q.isEmpty()){
			Road firstRoad = q.poll();
			int firstCity = firstRoad.getCity();
			selected[firstCity] = true;

			Iterator<Road> it = outEdges[firstCity].iterator();
			while(it.hasNext()){
				Road itNextRoad = it.next();
				int itNextCity = itNextRoad.getCity();

				if(!selected[itNextCity]){
					int newLength = length2[firstCity] + itNextRoad.getLength();

					if(newLength < length2[itNextCity]){
						boolean inQueue = (length2[itNextCity] < Integer.MAX_VALUE);
						length2[itNextCity] = newLength;

						if(inQueue){

							Road newRoad = new Road(itNextCity, length2[itNextCity]);
							q.remove(newRoad);
							newRoad.updateLength(newLength);
							q.add(newRoad);					

						}
						else{
							Road newRoad = new Road(itNextCity, newLength);
							q.add(newRoad);
						}
					}
				}
			}			

		}

		System.out.println(formulateResponse());

	}


	public String formulateResponse(){

		compareLengths();

		return cap1Counter + " " + cap2Counter + " " + cap1or2Counter;
	}

	public void compareLengths(){
		for(int i=0; i<nComunities; i++){
			if(length1[i] < length2[i]){
				cap1Counter++;
			}
			else if(length1[i] > length2[i]){
				cap2Counter++;
			}
			else
				cap1or2Counter++;
		}
	}
}
