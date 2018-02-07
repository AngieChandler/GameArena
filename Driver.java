public class Driver
{
	public static void main(String[] args){
		//demoes complementary graph, self-loop, density
		//new TriangleGraph();
		
		//demoes graph traversal
		//new StudentLife();
	
		//lecture slides' model for traversal

		//create GameArena - to draw on
		GameArena arena = new GameArena(1000,800);
		
		//create the graph class itself, currently empty, give it access to the GameArena (drawing pad!)
		Graph g = new Graph(arena);
		
		//add some nodes to the graph
		Node node = new Node(400,100,30,"RED","A");
		g.addNode(node);
		node = new Node(600,100,30,"ORANGE","B");
		g.addNode(node);
		node = new Node(200,300,30,"YELLOW","F");
		g.addNode(node);
		node = new Node(400,300,30,"GREEN","I");
		g.addNode(node);
		node = new Node(600,300,30,"LIGHTBLUE","H");
		g.addNode(node);
		node = new Node(800,300,30,"DARKBLUE","C");
		g.addNode(node);
		node = new Node(400,500,30,"PURPLE","E");
		g.addNode(node);
		node = new Node(600,500,30,"PINK","D");
		g.addNode(node);
		node = new Node(500,200,30,"BROWN","G");
		g.addNode(node);
		
		
		
		//add some arcs to the graph
		Arc arc = new Arc(g.getNode("A"),g.getNode("B"),2);
		g.addArc(arc);
		arc = new Arc(g.getNode("A"),g.getNode("G"),5);
		g.addArc(arc);
		arc = new Arc(g.getNode("A"),g.getNode("F"),9);
		g.addArc(arc);
		arc = new Arc(g.getNode("B"),g.getNode("G"),6);
		g.addArc(arc);
		arc = new Arc(g.getNode("B"),g.getNode("C"),4);
		g.addArc(arc);
		arc = new Arc(g.getNode("C"),g.getNode("H"),5);
		g.addArc(arc);
		arc = new Arc(g.getNode("C"),g.getNode("D"),2);
		g.addArc(arc);
		arc = new Arc(g.getNode("D"),g.getNode("H"),1);
		g.addArc(arc);
		arc = new Arc(g.getNode("D"),g.getNode("E"),1);
		g.addArc(arc);
		arc = new Arc(g.getNode("F"),g.getNode("E"),6);
		g.addArc(arc);
		arc = new Arc(g.getNode("G"),g.getNode("I"),2);
		g.addArc(arc);
		arc = new Arc(g.getNode("G"),g.getNode("H"),5);
		g.addArc(arc);
		arc = new Arc(g.getNode("I"),g.getNode("H"),4);
		g.addArc(arc);
		arc = new Arc(g.getNode("I"),g.getNode("E"),3);
		g.addArc(arc);
		arc = new Arc(g.getNode("I"),g.getNode("F"),1);
		g.addArc(arc);


		
		//draw the graph on the arena. Update the arena. Also, printout the graph (text version)
		g.drawGraph();
		arena.update();
		g.display();

		//calculate the density
		System.out.println("density = "+g.calculateDensity());

		System.out.println("Spanning tree");
		Node[] tree = g.spanningTreeBegin(g.getNode("A"));
		for(int i=0;i<tree.length-1;i++){
			System.out.print(tree[i].getName()+", ");
		}
		System.out.println(tree[tree.length-1].getName()+"\n");
		
		System.out.println();

		System.out.println("Breadth first traversal");
		Node[] breadth = g.breadthFirstTraversal(g.getNode("A"));
		for(int i=0;i<breadth.length-1;i++){
			System.out.print(breadth[i].getName()+", ");
		}
		System.out.println(breadth[breadth.length-1].getName()+"\n");

		System.out.println();
		
		System.out.println("Is graph strongly connected? "+g.stronglyConnected());

		
		//wait until space is pressed
		boolean space = false;
		while(!space){
			if(arena.spacePressed())
				space = true;	
			arena.update();
		}

	
	}
}