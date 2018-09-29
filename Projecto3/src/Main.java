import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static final int MAX_COMUNITIES = 20000;
	private static final int MIN_COMUNITIES = 2;
	private static final int MAX_ROADS = 150000;
	private static final int MIN_ROADS = 1;
	private static final int MAX_LENGTH = 1000;
	private static final int MIN_LENGTH = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer sTkn = new StringTokenizer(buffer.readLine());
		
		int numComunities = Integer.parseInt(sTkn.nextToken());
		int numRoads = Integer.parseInt(sTkn.nextToken());
		
		if (numComunities < MIN_COMUNITIES || numComunities > MAX_COMUNITIES || numRoads < MIN_ROADS || numRoads > MAX_ROADS) {
			buffer.close();
		}
		
		AdministrativeReform aRef = new AdministrativeReform(numComunities);
		
		int city1;
		int city2;
		int length;
		
		for (int i=0; i<numRoads; i++) {
			sTkn = new StringTokenizer(buffer.readLine());
			
			city1 = Integer.parseInt(sTkn.nextToken()); 
			city2 = Integer.parseInt(sTkn.nextToken());
			length = Integer.parseInt(sTkn.nextToken());
			
			if(length < MIN_LENGTH || length > MAX_LENGTH){
				buffer.close();
			}
			
			aRef.createRoad(city1, city2, length);
			
		}
		
		sTkn = new StringTokenizer(buffer.readLine());
		int cap1 = Integer.parseInt(sTkn.nextToken());
		int cap2 = Integer.parseInt(sTkn.nextToken());
		aRef.setCapitals(cap1, cap2);
		
		aRef.calcResult();
		
	}
	
}
