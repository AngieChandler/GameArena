public class Graph
{
	Node[] nodes;
	Arc[] arcs;
	
	GameArena arena;
	
	public Graph(){
		nodes = new Node[0];
		arcs = new Arc[0];
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
	
	//graphical only, simply draws the stored graph on the screen
	public void drawGraph(GameArena a){
		arena = a;
		
		Line line;
		Ball[] selfArc;
		for(int i=0;i<arcs.length;i++){
			line = arcs[i].getLine();
			if(line!=null)
				a.addLine(line);
			else{
				selfArc = arcs[i].getSelfArc();
				a.addBall(selfArc[0]);
				a.addBall(selfArc[1]);
			}
		}
		
		for(int i=0;i<nodes.length;i++){
			a.addBall(nodes[i].getDrawnNode());
		}
		
	}	
	
	//graphical only, draws the complementary graph on the screen
	//DOES NOT store it as part of the graph structure - the graph stored is unchanged
	public void drawComplementaryGraph(GameArena a){
		arena = a;

		int weight = nodes.length;
		int weightSq = weight*weight;
		int countArcs = arcs.length;
		
		Arc[] otherArcs = new Arc[weightSq - countArcs];
		int otherArcCount = 0;
		for(int i=0;i<weight;i++){
			Arc[] outArcs = nodes[i].getOutArcs();
			for(int j=0;j<weight;j++){
				boolean found = false;
				int k=0;
				while(k<outArcs.length && !found){
					if(nodes[j].equals(outArcs[k].getEndNode()))
						found = true;
					k++;
				}
				if(!found){
					otherArcs[otherArcCount] = new Arc(nodes[i],nodes[j]);
					otherArcCount++;
				}
			}
		}
		
		Line line;
		Ball[] selfArc;
		for(int i=0;i<otherArcs.length;i++){
			line = otherArcs[i].getLine();
			if(line!=null)
				a.addLine(line);
			else{
				selfArc = otherArcs[i].getSelfArc();
				a.addBall(selfArc[0]);
				a.addBall(selfArc[1]);
			}
		}
		
		
		for(int i=0;i<nodes.length;i++){
			a.addBall(nodes[i].getDrawnNode());
		}	
		
	}

}