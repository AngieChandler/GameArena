import java.util.*;
import java.awt.*;

public class Adjacency
{
	private int[][] matrix;
	private Random random = new Random();	

	public Adjacency(){
		GameArena arena = new GameArena(1000,800);
		Graph g = new Graph(arena);
		int matrixSize = 6;
		
		matrix = new int[][]{{0,1,1,0,0,0,500,100},
							 {0,0,0,1,0,0,200,150},
							 {1,0,0,0,1,0,800,150},
							 {0,0,0,0,0,0,150,550},
							 {0,1,0,1,0,1,500,500},
							 {0,0,0,0,0,1,800,550}};
		
		Node node;
		Arc arc;
		int size = 30;
		String colour;
		
		//have to create nodes first
		for(int i=0;i<matrixSize;i++){
			colour = String.format("#%06X", randomColour());
			node = new Node(matrix[i][matrixSize],matrix[i][matrixSize+1],size,colour,""+i);
			g.addNode(node);
		}
		//then arcs
		for(int i=0;i<matrixSize;i++){
			for(int j=0;j<matrixSize;j++){
				if(matrix[i][j] == 1){
					arc = new Arc(g.getNode(""+i),g.getNode(""+j));
					g.addArc(arc);
				}
			}
		}
		
	
		g.drawGraph();
		arena.update();
		g.display();
	
	}


	private int randomColour(){
		int colour;
		int[] c = new int[3];
		boolean low = true;
		
		//random value for each colour
		for(int i=0;i<3;i++){
			c[i] = random.nextInt(255);
			if(c[i]>120)
				low = false;
		}
		
		//if dim, brighten everything
		if(low){
			for(int i=0;i<3;i++){
				c[i] += 120;
			}
		}

		//shift red and green along so that a single number is formed
		colour = (c[0]<<16) + (c[1]<<8) + c[2];
		
		//System.out.println(String.format("#%06X", colour));		
		
		return colour;
	}




}