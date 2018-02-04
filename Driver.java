public class Driver
{
	public static void main(String[] args){
		GameArena arena = new GameArena(1000,800);
		
		Graph g = new Graph(arena);
		Node node = new Node(250,450,30,"BLUE","blue");
		g.addNode(node);
		node = new Node(400, 130, 30, "RED","red");
		g.addNode(node);
		node = new Node(550,450,30,"YELLOW","yellow");
		g.addNode(node);
		
		Arc arc = new Arc(g.getNode("blue"),g.getNode("yellow"));
		g.addArc(arc);
	
		arena.update();
		g.display();
	}

}