public class Graph
{
	Node[] nodes;
	Arc[] arcs;
	
	GameArena arena;
	
	public Graph(GameArena arena){
		nodes = new Node[0];
		arcs = new Arc[0];
		
		this.arena = arena;
	}

	public void display(){
		System.out.println("*****************************");
		System.out.println("Graph");
		for(int i=0;i<nodes.length;i++){
			nodes[i].display();
		}
		for(int i=0;i<arcs.length;i++){
			arcs[i].display();
		}
		System.out.println("*****************************");
	}
	
	public Node getNode(String name){
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].getName().equals(name))
				return nodes[i];
		}
		return null;
	}
	
	public void addNode(Node node){
		arena.addBall(node.getDrawnNode());
		
		int i=0;
		while(i<nodes.length && nodes[i]!=null){
			i++;
		}
		if(i<nodes.length){
			nodes[i] = node;
			return;
		}
		
		Node[] oldNode = nodes;
		
		nodes = new Node[oldNode.length+1];
		for(i=0;i<oldNode.length;i++){
			nodes[i] = oldNode[i];
		}
		nodes[oldNode.length] = node;
	}
	
	public void addArc(Arc arc){
		//arena.addBall(node.getDrawnNode());
		
		int i=0;
		while(i<arcs.length && arcs[i]!=null){
			i++;
		}
		if(i<arcs.length){
			arcs[i] = arc;
			return;
		}
		
		Arc[] oldArc = arcs;
		
		arcs = new Arc[oldArc.length+1];
		for(i=0;i<oldArc.length;i++){
			arcs[i] = oldArc[i];
		}
		arcs[oldArc.length] = arc;
	}


}