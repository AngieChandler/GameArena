public class Driver
{
	public static void main(String[] args){
		Graph g = new Graph();
		Node node = new Node(250,450,30,"BLUE","blue");
		g.addNode(node);
		node = new Node(400, 130, 30, "RED","red");
		g.addNode(node);
		node = new Node(550,450,30,"YELLOW","yellow");
		g.addNode(node);
		
		Arc arc = new Arc(g.getNode("blue"),g.getNode("yellow"));
		g.addArc(arc);
		arc = new Arc(g.getNode("yellow"),g.getNode("blue"));
		g.addArc(arc);
		arc = new Arc(g.getNode("red"),g.getNode("red"));
		g.addArc(arc);
		
		GameArena arena = new GameArena(1000,800);
		//g.drawGraph(arena);
		g.drawComplementaryGraph(arena);
		arena.update();
		g.display();
		
		System.out.println("density = "+g.calculateDensity());

	}

}