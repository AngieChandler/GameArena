public class LectureTraversal
{

	public LectureTraversal(){
	
			//create GameArena - to draw on
		GameArena arena = new GameArena(1000,800);
		
		//create the graph class itself, currently empty, give it access to the GameArena (drawing pad!)
		Graph g = new Graph(arena);
		
		//add some nodes to the graph
		Node node = new Node(500,100,30,"BLUE","0");
		g.addNode(node);
		node = new Node(200, 150, 30, "RED","1");
		g.addNode(node);
		node = new Node(800,150,30,"YELLOW","2");
		g.addNode(node);
		node = new Node(150,550,30,"GREEN","3");
		g.addNode(node);
		node = new Node(500,500,30,"PURPLE","4");
		g.addNode(node);
		node = new Node(800,550,30,"ORANGE","5");
		g.addNode(node);
		
		
		//add some arcs to the graph
		Arc arc = new Arc(g.getNode("0"),g.getNode("1"));
		g.addArc(arc);
		arc = new Arc(g.getNode("0"),g.getNode("2"));
		g.addArc(arc);
		arc = new Arc(g.getNode("1"),g.getNode("3"));
		g.addArc(arc);
		arc = new Arc(g.getNode("2"),g.getNode("0"));
		g.addArc(arc);
		arc = new Arc(g.getNode("2"),g.getNode("4"));
		g.addArc(arc);
		arc = new Arc(g.getNode("4"),g.getNode("1"));
		g.addArc(arc);
		arc = new Arc(g.getNode("4"),g.getNode("3"));
		g.addArc(arc);
		arc = new Arc(g.getNode("4"),g.getNode("5"));
		g.addArc(arc);
		arc = new Arc(g.getNode("5"),g.getNode("5"));
		g.addArc(arc);

		
		//draw the graph on the arena. Update the arena. Also, printout the graph (text version)
		g.drawGraph();
		arena.update();
		g.display();

		//calculate the density
		System.out.println("density = "+g.calculateDensity());

				System.out.println("Spanning tree");
		Node[] tree = g.spanningTreeBegin(g.getNode("0"));
		for(int i=0;i<tree.length-1;i++){
			System.out.print(tree[i].getName()+", ");
		}
		System.out.println(tree[tree.length-1].getName()+"\n");
		
		System.out.println();

		System.out.println("Breadth first traversal");
		Node[] breadth = g.breadthFirstTraversal(g.getNode("0"));
		for(int i=0;i<breadth.length-1;i++){
			System.out.print(breadth[i].getName()+", ");
		}
		System.out.println(breadth[breadth.length-1].getName()+"\n");

		System.out.println();
		
		System.out.println("Is graph strongly connected? "+g.stronglyConnected());

		
	}
}