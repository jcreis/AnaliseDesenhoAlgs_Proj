import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Maze {

	private char[][] maze;

	private boolean[][][][] visited;

	private Queue<PositionNode> q = new LinkedList<PositionNode>();


	public Maze(char[][] maze){
		this.maze = maze;
	}

	public void createMap(int nCol, int nRows, int xL, int yL, int xN, int yN, int xS, int yS) {

		visited = new boolean[nRows][nCol][nRows][nCol];

		PositionNode initialNode = new PositionNode(xN-1, yN-1, xS-1, yS-1, 0);
		q.add(initialNode);
		visited[xN-1][yN-1][xS-1][yS-1] = true;

		PositionNode finalNode = new PositionNode(xL-1, yL-1, xL-1, yL-1, 0);

		String result = calcResult(finalNode, nCol, nRows);

		System.out.println(result);
	}

	public String calcResult(PositionNode finalNode, int nColumns, int nRows){

		// So para ver se o inicial e solucao
		PositionNode checkNode = q.peek();
		int newX1 = checkNode.getX1();
		int newY1 = checkNode.getY1();
		int newX2 = checkNode.getX2();
		int newY2 = checkNode.getY2();

		if(isFinal(newX1, newY1, newX2, newY2, finalNode)){
			return finalNode.getResult();
		}


		// Se o inicial nao e solucao
		while(!q.isEmpty()){

			PositionNode node = q.poll();
			int cost = node.getCost();
			newX1 = node.getX1();
			newY1 = node.getY1();
			newX2 = node.getX2();
			newY2 = node.getY2();

			PositionNode newNode;

			// EAST
			int y1 = newY1;
			if(node.getY1()+1<nColumns && maze[node.getX1()][node.getY1()+1] == '.'){
				y1 = newY1+1;
			}

			int y2 = newY2;
			if(node.getY2()-1>=0 && maze[node.getX2()][node.getY2()-1] == '.'){
				y2 = newY2-1;
			}

			if(!visited[newX1][y1][newX2][y2]){
				newNode = new PositionNode(newX1, y1, newX2, y2, cost+1);
				visited[newX1][y1][newX2][y2] = true;
				q.add(newNode);

				if(isFinal(newX1, y1, newX2, y2, finalNode)){
					return newNode.getResult();
				}
			}							

			// WEST
			y1 = newY1;
			if(node.getY1()-1>=0 && maze[node.getX1()][node.getY1()-1] == '.'){
				y1 = newY1-1;
			}

			y2 = newY2;

			if(node.getY2()+1<nColumns && maze[node.getX2()][node.getY2()+1] == '.'){
				y2 = newY2+1;
			}

			if(!visited[newX1][y1][newX2][y2]){
				newNode = new PositionNode(newX1, y1, newX2, y2, cost+1);
				visited[newX1][y1][newX2][y2] = true;
				q.add(newNode);

				if(newX1 == finalNode.getX1() && y1 == finalNode.getY1() && newX2 == finalNode.getX2() && y2 == finalNode.getY2()){
					return newNode.getResult();
				}
			}			

			// NORTH
			int x1 = newX1;
			if(node.getX1()+1<nRows && maze[node.getX1()+1][node.getY1()] == '.'){

				x1 = newX1+1;
			}

			int x2 = newX2;

			if(node.getX2()+1<nRows && maze[node.getX2()+1][node.getY2()] == '.'){
				x2 = newX2+1;
			}

			if(!visited[x1][newY1][x2][newY2]){
				newNode = new PositionNode(x1, newY1, x2, newY2, cost+1);
				visited[x1][newY1][x2][newY2] = true;
				q.add(newNode);

				if(x1 == finalNode.getX1() && newY1 == finalNode.getY1() && x2 == finalNode.getX2() && newY2 == finalNode.getY2()){				
					return newNode.getResult();
				}
			}

			// SOUTH
			x1 = newX1;
			if(node.getX1()-1>=0 && maze[node.getX1()-1][node.getY1()] == '.'){

				x1 = newX1-1;
			}
			x2 = newX2;

			if(node.getX2()-1>=0 && maze[node.getX2()-1][node.getY2()] == '.'){
				x2 = newX2-1;
			}

			if(!visited[x1][newY1][x2][newY2]){
				newNode = new PositionNode(x1, newY1, x2, newY2, cost+1);
				visited[x1][newY1][x2][newY2] = true;
				q.add(newNode);

				if(x1 == finalNode.getX1() && newY1 == finalNode.getY1() && x2 == finalNode.getX2() && newY2 == finalNode.getY2()){
					return newNode.getResult();
				}
			}			

		}
		return "NO LOVE";
	}

	private boolean isFinal(int newX1, int newY1, int newX2, int newY2, PositionNode finalNode){
		return newX1 == finalNode.getX1() && newY1 == finalNode.getY1() && newX2 == finalNode.getX2() && newY2 == finalNode.getY2();
	}

}
