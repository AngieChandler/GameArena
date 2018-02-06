/** Graph class, contains an array of Nodes and an Array of Arcs. Performs operations on the graph.
*/
public class Graph
{
	//the arrays of nodes and arcs that form this graph
	private Node[] nodes;
	private Arc[] arcs;
	
	//the GameArena for drawing on
	private GameArena arena;

	/** constructor - initialise arrays to empty (so that there are never any empty values)
	* will increase size of arrays as we go on.
	* also, store the GameArena reference for later.
	* @param a GameArena on which this graph will be drawn
	*/
	public Graph(GameArena a){
		nodes = new Node[0];
		arcs = new Arc[0];
		
		arena = a;
	}

	/** display details (textual) of the graph
	*/
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

	/** find a node from within the graph based on the node's name
	* @param name the name of the node
	* @return the node with the matching name
	*/
	public Node getNode(String name){
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].getName().equals(name))
				return nodes[i];
		}
		return null;
	}

	/** add a node to the graph, also increases the size of the node array to accommodate the new node
	* @param node the Node to be added to the graph
	*/
	public void addNode(Node node){		
		Node[] oldNode = nodes;
		
		nodes = new Node[oldNode.length+1];
		for(int i=0;i<oldNode.length;i++){
			nodes[i] = oldNode[i];
		}
		nodes[oldNode.length] = node;
	}
	
	/** add an arc to the graph, also increases the size of the arc array to accommodate the new arc
	* @param arc the Arc to be added to the graph
	*/
	public void addArc(Arc arc){
		Arc[] oldArc = arcs;
		
		arcs = new Arc[oldArc.length+1];
		for(int i=0;i<oldArc.length;i++){
			arcs[i] = oldArc[i];
		}
		arcs[oldArc.length] = arc;
	}
	
	/** calculate the graph's density
	* @return density as a double
	*/
	public double calculateDensity(){
		int weight = nodes.length;
		int weightSq = weight*weight;
		int countArcs = arcs.length;
		
		return (double)countArcs/(double)weightSq;
	}
	

	
	/** reset graph drawing, removes all drawing objects from the GameArena
	*/
	public void resetGraph(){
		for(int i=0;i<nodes.length;i++){
			arena.removeBall(nodes[i].getDrawnNode());
			arena.removeText(nodes[i].getLabel());
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
	
	
	/** graphical only, draws the stored graph on the GameArena
	*/
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
			arena.addText(nodes[i].getLabel());
		}
		
	}	
	
	/** generates the complementary graph
	* @return the complementary graph
	*/
	public Graph complement(){
		Graph comp = new Graph(this.arena);

		int weight = nodes.length;

		//add current nodes to separate graph
		for(int i=0;i<nodes.length;i++){
			Node newNode = new Node((int)nodes[i].getXPosition(),(int)nodes[i].getYPosition(),(int)nodes[i].getDiameter(),nodes[i].getColour(),nodes[i].getName());
			comp.addNode(newNode);
		}	

		//work out which arcs we have, and therefore the ones that are missing
		//add the missing arcs to the other graph
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
	
	/** generates the full graph for these nodes
	* @return the fully connected graph 
	*/
	public Graph fullyConnect(){
		Graph full = new Graph(arena);

		int weight = nodes.length;

		Arc newArc;
		Node newNode;

		//add current nodes and arcs (to a separate graph)
		for(int i=0;i<weight;i++){
			newNode = new Node((int)nodes[i].getXPosition(),(int)nodes[i].getYPosition(),(int)nodes[i].getDiameter(),nodes[i].getColour(),nodes[i].getName());
			full.addNode(newNode);
		}	
		for(int i=0;i<arcs.length;i++){
			newArc = new Arc(full.getNode(arcs[i].getStartNode().getName()),full.getNode(arcs[i].getEndNode().getName()));
			full.addArc(newArc);
		}
			
		//work out which arcs are missing and add those
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