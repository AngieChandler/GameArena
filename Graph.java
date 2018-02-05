public class Graph
{
	private Node[] nodes;
	private Arc[] arcs;
	
	private GameArena arena;
		
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
	
	public double calculateDensity(){
		int weight = nodes.length;
		int weightSq = weight*weight;
		int countArcs = arcs.length;
		
		return (double)countArcs/(double)weightSq;
	}
	

	
	//reset graph drawing
	public void resetGraph(){
		for(int i=0;i<nodes.length;i++){
			arena.removeBall(nodes[i].getDrawnNode());
		}
		for(int i=0;i<arcs.length;i++){
			if(!arcs[i].isSelfArc())
				arena.removeLine(arcs[i].getLine());
			else{
				Ball[] selfArc = arcs[i].getSelfArc();
				arena.removeBall(selfArc[0]);
				arena.removeBall(selfArc[1]);
			}
		}
	}
	
	
	//graphical only, simply draws the stored graph on the screen
	public void drawGraph(){
		resetGraph();
		Ball[] selfArc;
		for(int i=0;i<arcs.length;i++){
			if(!arcs[i].isSelfArc())
				arena.addLine(arcs[i].getLine());
			else{
				selfArc = arcs[i].getSelfArc();
				arena.addBall(selfArc[0]);
				arena.addBall(selfArc[1]);
			}
		}
		
		for(int i=0;i<nodes.length;i++){
			arena.addBall(nodes[i].getDrawnNode());
		}
		
	}	
	
	//generates the complementary graph
	public Graph complement(){
		Graph comp = new Graph(this.arena);

		int weight = nodes.length;
		int weightSq = weight*weight;
		int countArcs = arcs.length;

		for(int i=0;i<nodes.length;i++){
			Node newNode = new Node((int)nodes[i].getXPosition(),(int)nodes[i].getYPosition(),(int)nodes[i].getDiameter(),nodes[i].getColour(),nodes[i].getName());
			comp.addNode(newNode);
		}	

		Arc newArc;
		for(int i=0;i<weight;i++){
			Arc[] outArcs = nodes[i].getOutArcs();
			for(int j=0;j<weight;j++){
				boolean found = false;
				int k=0;
				while(k<outArcs.length && !found){
					if(nodes[j].equals(outArcs[k].getEndNode())){
						found = true;
					}
					k++;
				}
				if(!found){
					newArc = new Arc(comp.getNode(nodes[i].getName()),comp.getNode(nodes[j].getName()));
					comp.addArc(newArc);
				}
			}
		}
		return comp;
	}
	
	//generates the full graph
	public Graph fullyConnect(){
		Graph full = new Graph(arena);

		int weight = nodes.length;
		int weightSq = weight*weight;
		int countArcs = arcs.length;

		Arc newArc;
		Node newNode;

		for(int i=0;i<nodes.length;i++){
			newNode = new Node((int)nodes[i].getXPosition(),(int)nodes[i].getYPosition(),(int)nodes[i].getDiameter(),nodes[i].getColour(),nodes[i].getName());
			full.addNode(newNode);
		}	
		for(int i=0;i<arcs.length;i++){
			newArc = new Arc(full.getNode(arcs[i].getStartNode().getName()),full.getNode(arcs[i].getEndNode().getName()));
			full.addArc(newArc);
		}
		
		
		for(int i=0;i<weight;i++){
			Arc[] outArcs = nodes[i].getOutArcs();
			for(int j=0;j<weight;j++){
				boolean found = false;
				int k=0;
				while(k<outArcs.length && !found){
					if(nodes[j].equals(outArcs[k].getEndNode())){
						found = true;
					}
					k++;
				}
				if(!found){
					newArc = new Arc(full.getNode(nodes[i].getName()),full.getNode(nodes[j].getName()));
					full.addArc(newArc); 
				}
			}
		}
		
		return full;

	}

}