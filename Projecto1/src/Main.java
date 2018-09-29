import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String s = buffer.readLine();
		StringTokenizer strTkn = new StringTokenizer(s);
		int numArmies = Integer.parseInt(strTkn.nextToken());
		int numPopulations = Integer.parseInt(strTkn.nextToken());
		Warfare war = new Warfare(numArmies, numPopulations);

		for(int i=0; i<numArmies; i++){
			s = buffer.readLine();
			strTkn = new StringTokenizer(s);
			int posX = Integer.parseInt(strTkn.nextToken());
			int posY = Integer.parseInt(strTkn.nextToken());
			int mainCost = Integer.parseInt(strTkn.nextToken());

			war.addArmy(posX, posY, mainCost);
		}

		for(int i=0; i<numPopulations; i++){
			s = buffer.readLine();
			strTkn = new StringTokenizer(s);
			int posX = Integer.parseInt(strTkn.nextToken());
			int posY = Integer.parseInt(strTkn.nextToken());
			int wealth = Integer.parseInt(strTkn.nextToken());

			war.addPopulation(posX, posY, wealth);
		}

		war.calcResult();

		System.out.print(war.getWealth() + " ");
		System.out.print(war.getDistances() + " ");
		System.out.print(war.getCosts());
		
		buffer.close();
	}

}
