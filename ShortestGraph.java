public class ShortestGraph
{
	public ShortestGraph(){
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
		
		Node[] path = g.dijkstra(g.getNode("A"),g.getNode("H"));
		System.out.println("Shortest path");
		for(int i=0;i<path.length;i++){
			if(path[i]!=null)
				System.out.print(path[i].getName()+", ");
		}
		System.out.println();
	}



}