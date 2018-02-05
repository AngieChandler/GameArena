public class Driver
{
	public static void main(String[] args){
		//create GameArena - to draw on
		GameArena arena = new GameArena(1000,800);
		
		//create the graph class itself, currently empty, give it access to the GameArena (drawing pad!)
		Graph g = new Graph(arena);
		
		//add some nodes to the graph
		Node node = new Node(250,450,30,"BLUE","blue");
		g.addNode(node);
		node = new Node(400, 130, 30, "RED","red");
		g.addNode(node);
		node = new Node(550,450,30,"YELLOW","yellow");
		g.addNode(node);
		
		
		//add some arcs to the graph
		Arc arc = new Arc(g.getNode("blue"),g.getNode("yellow"));
		g.addArc(arc);
		arc = new Arc(g.getNode("yellow"),g.getNode("blue"));
		g.addArc(arc);
		arc = new Arc(g.getNode("red"),g.getNode("red"));
		g.addArc(arc);
		
		//draw the graph on the arena. Update the arena. Also, printout the graph (text version)
		g.drawGraph();
		arena.update();
		g.display();

		//calculate the density
		System.out.println("density = "+g.calculateDensity());

		//wait until space is pressed
		boolean space = false;
		while(!space){
			if(arena.spacePressed())
				space = true;	
			arena.update();
		}
		
		//clear the screen (remove connection between arena and nodes/arcs. All nodes/arcs still exist in the graph)
		g.resetGraph();
		
		//generate the complementary graph in a separate graph class and draw that on the game arena.
		//also print out the nodes and arcs (as text) and the density.
		Graph comp = g.createComplementaryGraph();
		comp.drawGraph();
		arena.update();
		comp.display();
		System.out.println("density (complementary) = "+comp.calculateDensity());
		
		//wait until left cursor key is pressed
		boolean left = false;
		while(!left){
			if(arena.leftPressed())
				left = true;	
			arena.update();
		}

		//clear screen
		g.resetGraph();
		arena.update();
		
		Graph full = g.createFullGraph();
		full.drawGraph();
		System.out.println("density = "+full.calculateDensity());
		
		//wait until right cursor key is pressed
		boolean right = false;
		while(!right){
			if(arena.rightPressed())
				right = true;	
			arena.update();
		}
		
		//clear screen
		g.resetGraph();
		arena.update();

		//the complementary graph of the complementary graph!
		Graph compcomp = comp.createComplementaryGraph();
		compcomp.display();
		compcomp.drawGraph();
		System.out.println("compcomp density = "+compcomp.calculateDensity());
		arena.update();
		
	

	
		
		//other things we could add :)
		//connectivity
		//paths..
		//diameter
		//depth first search - using a stack
		//breadth first search - using a queue
		//dijkstra's algorithm
	}

}