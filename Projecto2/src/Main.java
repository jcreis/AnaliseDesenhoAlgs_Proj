import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		do{
			line = reader.readLine();
			StringTokenizer sTkn1 = new StringTokenizer(line);
			int numRows = Integer.parseInt(sTkn1.nextToken());
			int numColumns = Integer.parseInt(sTkn1.nextToken());

			StringTokenizer sTkn2 = new StringTokenizer(reader.readLine());
			// love cell
			int xL = Integer.parseInt(sTkn2.nextToken());
			int yL = Integer.parseInt(sTkn2.nextToken());

			// nala
			int xN = Integer.parseInt(sTkn2.nextToken());
			int yN = Integer.parseInt(sTkn2.nextToken());

			// simba
			int xS = Integer.parseInt(sTkn2.nextToken());
			int yS = Integer.parseInt(sTkn2.nextToken());

			char[][] maze = new char[numRows][numColumns];
			for(int i=0; i<numRows; i++){
				String s = reader.readLine();

				for(int j=0; j<numColumns; j++){
					maze[i][j] = s.charAt(j);

				}
			}
			Maze map1 = new Maze(maze);
			map1.createMap(numColumns, numRows, xL, yL, xN, yN, xS, yS);
			
		}while(reader.ready());
	}
}
