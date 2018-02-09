public class LectureDraw
{

	public LectureDraw(){
	
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
		
		Node[] depthTraversal = g.depthFirstDraw(g.getNode("0"),g.getNode("5"));
		for(int i=0;i<depthTraversal.length-1;i++){
			System.out.print(depthTraversal[i].getName()+", ");
		}
		System.out.println(depthTraversal[depthTraversal.length-1].getName()+"\n");

		System.out.println();

		boolean space = false;
		while(!space){
			if(arena.spacePressed())
				space = true;
			arena.update();
		}

		g.resetGraph();
		
		Graph temp = g.spanningTreeDraw(g.getNode("0"));

		Graph tree = new Graph(arena);
		
		Node[] nodes = temp.getNodes();
		for(int i=0;i<nodes.length;i++){
			tree.addNode(nodes[i]);
		}
		
		Arc[] arcs = temp.getArcs();
		for(int i=0;i<arcs.length;i++){
			tree.addArc(arcs[i]);
		}
		
		tree.drawGraph();
		arena.update();

		boolean left = false;
		while(!left){
			if(arena.leftPressed())
				left = true;
			arena.update();
		}
		
		g.resetGraph();
		tree.resetGraph();
		g.drawGraph();

		System.out.println("Breadth first traversal");
		Node[] breadth = g.breadthFirstDraw(g.getNode("0"));
		for(int i=0;i<breadth.length-1;i++){
			System.out.print(breadth[i].getName()+", ");
		}
		System.out.println(breadth[breadth.length-1].getName()+"\n");

		System.out.println();
		
		System.out.println("Is graph strongly connected? "+g.stronglyConnected());
		
		
	}
}