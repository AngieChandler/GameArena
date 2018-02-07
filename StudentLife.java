public class StudentLife
{
	public StudentLife()
	{
		//create a GameArena
		GameArena arena = new GameArena(1000,800);

		//create a Graph
		Graph g = new Graph(arena);
		
		//add nodes to graph
		Node node = new Node(200,100,30,"LIGHTBLUE","S");
		g.addNode(node);
		
		node = new Node(200,300,30,"BROWN","C");
		g.addNode(node);
		
		node = new Node(400,500,30,"GRAY","L");
		g.addNode(node);
		
		node = new Node(600,300,30,"RED","P");
		g.addNode(node);
		
		node = new Node(600,100,30,"HOTPINK","H");
		g.addNode(node);
		
		//add arcs to graph
		Arc arc = new Arc(g.getNode("S"),g.getNode("C"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("C"),g.getNode("L"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("L"),g.getNode("C"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("C"),g.getNode("P"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("L"),g.getNode("P"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("P"),g.getNode("P"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("P"),g.getNode("H"));
		g.addArc(arc);
		
		arc = new Arc(g.getNode("H"),g.getNode("S"));
		g.addArc(arc);
		
		//draw Graph
		g.drawGraph();
		arena.update();
		g.display();
		
		System.out.println("density = "+g.calculateDensity());
		
		System.out.println();
		
		System.out.println("Traversal: S to P");
		Node[] depthTraversal = g.depthFirstBegin(g.getNode("S"),g.getNode("P"));
		for(int i=0;i<depthTraversal.length-1;i++){
			System.out.print(depthTraversal[i].getName()+", ");
		}
		System.out.println(depthTraversal[depthTraversal.length-1].getName()+"\n");

		System.out.println();

		System.out.println("Spanning tree");
		Node[] tree = g.spanningTreeBegin(g.getNode("S"));
		for(int i=0;i<tree.length-1;i++){
			System.out.print(tree[i].getName()+", ");
		}
		System.out.println(tree[tree.length-1].getName()+"\n");
		
		System.out.println();

		System.out.println("Breadth first traversal");
		Node[] breadth = g.breadthFirstTraversal(g.getNode("S"));
		for(int i=0;i<breadth.length-1;i++){
			System.out.print(breadth[i].getName()+", ");
		}
		System.out.println(breadth[breadth.length-1].getName()+"\n");

		System.out.println();
		
		System.out.println("Is graph strongly connected? "+g.stronglyConnected());
		
		
		
		
	}

}