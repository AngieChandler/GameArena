/** Graph class, contains an array of Nodes and an Array of Arcs. Performs operations on the graph.
*/
public class Graph
{
	//the arrays of nodes and arcs that form this graph
	private Node[] nodes;
	private Arc[] arcs;
	
	//the GameArena for drawing on
	private GameArena arena;
	
	//used for building alternative graphs and showing traversals
	private Graph tree;
	private Ball traverse;

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
	
	public Node[] getNodes(){
		return nodes;
	}
	
	public Arc[] getArcs(){
		return arcs;
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
	
	
	
	/******************************************************************************************************************************/
	/* graph manipulations */
	
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
	
	/******************************************************************************************************************************/
	/* traversals */
	
	public Node[] spanningTreeBegin(Node startNode){
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}

		Stack nodeStack = new Stack();
		
		nodeStack = spanningTree(startNode,nodeStack);
		
		int size = nodeStack.getSize();
		
		Node[] order = new Node[size];
		for(int i=size-1;i>=0;i--){
			order[i] = nodeStack.pop().getNode();
		}
		
		return order;
	}
		
	private Stack spanningTree(Node startNode,Stack stack)
	{
		stack.push(new Element(startNode));
		startNode.setVisited();
		Arc[] outArcs = startNode.getOutArcs();
		for(int i=0;i<outArcs.length;i++){
			if(!outArcs[i].getEndNode().isVisited())	
				spanningTree(outArcs[i].getEndNode(),stack);
			
		}
		return stack;
		
	}

	
	public Node[] depthFirstBegin(Node startNode,Node endNode){
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}

		Stack nodeStack = new Stack();
		
		nodeStack = depthFirstTraversal(startNode,endNode,nodeStack);
		
		int size = nodeStack.getSize();
		
		Node[] order = new Node[size+1];
		order[size] = endNode;
		for(int i=size-1;i>=0;i--){
			order[i] = nodeStack.pop().getNode();
		}
		
		return order;
	}
		
	private Stack depthFirstTraversal(Node startNode,Node endNode,Stack stack)
	{
		if(startNode.equals(endNode))
			return stack;
		
		stack.push(new Element(startNode));
		startNode.setVisited();
		Arc[] outArcs = startNode.getOutArcs();
		for(int i=0;i<outArcs.length;i++){
			if(!outArcs[i].getEndNode().isVisited())	
				depthFirstTraversal(outArcs[i].getEndNode(),endNode,stack);
			
		}
		return stack;
		
	}
	
	
	public Node[] breadthFirstTraversal(Node startNode)
	{
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}

		Queue result = new Queue();
		Queue queue = new Queue();
		Node current;
		
		startNode.setVisited();
		queue.add(new Element(startNode));
		result.add(new Element(startNode));
		
		while(!queue.isEmpty()){
			current = queue.remove().getNode();
			
			Arc[] outArcs = current.getOutArcs();
			for(int i=0;i<outArcs.length;i++){
				if(!outArcs[i].getEndNode().isVisited())
				{
					outArcs[i].getEndNode().setVisited();
					queue.add(new Element(outArcs[i].getEndNode()));
					result.add(new Element(outArcs[i].getEndNode()));

				}
			}					
			
		}

		Node[] order = new Node[result.getSize()];
		for(int i=0;i<order.length;i++){
			order[i] = result.remove().getNode();
		}
	
		return order;
	}
	
	public boolean stronglyConnected(){
		Node[] result;
			
		for(int i=0;i<nodes.length;i++){
			result = spanningTreeBegin(nodes[i]);
			if(result.length < nodes.length)
				return false;
		}
		return true;
	}

	public Node[] dijkstra(Node startNode, Node endNode)
	{
		Node[] tree = new Node[nodes.length];
		Node[] fringe = new Node[nodes.length];
		
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}
		
		int treeSize = 0;
		int fringeSize = 0;
		
		tree[0] = startNode;
		treeSize++;
		
		boolean inFringe = false;
		Arc[] outArcs;
		boolean endInTree = false;
		int k=0;
		
		while(!endInTree){
			//(re)generate fringe using new element of tree
			int i = treeSize-1;
			outArcs = tree[i].getOutArcs();
			for(int j=0;j<outArcs.length;j++){
				inFringe = false;
				k=0;
				if(!outArcs[j].getEndNode().isVisited()){
					while(!inFringe && k<fringeSize)
					{	
						if(fringe[k].getName().equals(outArcs[j].getEndNode().getName())){
							inFringe = true;
							if(fringe[k].getDistance()>(outArcs[j].getWeight()+tree[i].getDistance()))
								fringe[k].setDistance(outArcs[j].getWeight());
						}
						k++;	
					}
					if(!inFringe)
					{
						fringe[fringeSize] = outArcs[j].getEndNode();
						fringe[fringeSize].setDistance(outArcs[j].getWeight()+tree[i].getDistance());
						fringeSize++;
					}
				}
			
				//choose one from fringe
				int position = 0;
				int distance = fringe[position].getDistance();
				for(int l=1;l<fringeSize-1;l++){
					if(fringe[l].getDistance()<distance){
						position = l;
						distance = fringe[l].getDistance();
					}
				}
				tree[treeSize] = fringe[position];
				tree[treeSize].setVisited();
				treeSize++;
				fringe[position] = fringe[fringeSize-1];
				fringeSize--;			
			}
			
			//check end not in tree
			if(tree[treeSize-1].getName().equals(endNode.getName()))
				endInTree = true;
		}
		
		return tree;
	}
/**********************************************************************************************************************************/
/*** traversals with drawing *****************/

	public Graph spanningTreeDraw(Node startNode){
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}

		tree = new Graph(arena);
		Stack nodeStack = new Stack();

		tree.addNode(startNode);		
		nodeStack = spanningTreeDrawing(startNode,nodeStack);
		
		int size = nodeStack.getSize();
		
		Node[] order = new Node[size];
		for(int i=size-1;i>=0;i--){
			order[i] = nodeStack.pop().getNode();
		}
		
		return tree;
	}
		
	private Stack spanningTreeDrawing(Node startNode,Stack stack)
	{
		stack.push(new Element(startNode));
		startNode.setVisited();
		Arc[] outArcs = startNode.getOutArcs();
		for(int i=0;i<outArcs.length;i++){
			if(!outArcs[i].getEndNode().isVisited()){	
				tree.addNode(outArcs[i].getEndNode());
				tree.addArc(outArcs[i]);
				spanningTreeDrawing(outArcs[i].getEndNode(),stack);
			}			
		}
		return stack;
		
	}

	private void graphWait(int length){
		try{
			Thread.sleep(length);
		}
		catch(InterruptedException e){}	
	}
	
	
	public Node[] depthFirstDraw(Node startNode,Node endNode){
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}
		
		//ball to mark the progress of search
		traverse = new Ball(startNode.getXPosition(),startNode.getYPosition(),20,"WHITE");
		arena.addBall(traverse);
		arena.update();
	
		Stack nodeStack = new Stack();
		
		nodeStack = depthFirstTravDraw(startNode,endNode,nodeStack);
		
		int size = nodeStack.getSize();
		
		Node[] order = new Node[size+1];
		order[size] = endNode;
		for(int i=size-1;i>=0;i--){
			order[i] = nodeStack.pop().getNode();
		}
		
		//remove visualisation
		arena.removeBall(traverse);
		
		return order;
	}
		
	private Stack depthFirstTravDraw(Node startNode,Node endNode,Stack stack)
	{
		//change view and give us time to see it
		traverse.setXPosition(startNode.getXPosition());
		traverse.setYPosition(startNode.getYPosition());
		arena.update();
		graphWait(5000);

		if(startNode.equals(endNode))
			return stack;
		
		stack.push(new Element(startNode));
		startNode.setVisited();
		
		
		Arc[] outArcs = startNode.getOutArcs();
		for(int i=0;i<outArcs.length;i++){
			if(!outArcs[i].getEndNode().isVisited())	
				depthFirstTravDraw(outArcs[i].getEndNode(),endNode,stack);
			
		}
		return stack;
		
	}
	
	
	public Node[] breadthFirstDraw(Node startNode)
	{
		//set up
		for(int i=0;i<nodes.length;i++){
			nodes[i].resetVisited();
		}

		//ball to mark the progress of search
		traverse = new Ball(startNode.getXPosition(),startNode.getYPosition(),20,"WHITE");
		arena.addBall(traverse);
		arena.update();

		
		Queue result = new Queue();
		Queue queue = new Queue();
		Node current;
		
		startNode.setVisited();
		queue.add(new Element(startNode));
		result.add(new Element(startNode));
		
		while(!queue.isEmpty()){
			current = queue.remove().getNode();
			
			Arc[] outArcs = current.getOutArcs();
			for(int i=0;i<outArcs.length;i++){
				if(!outArcs[i].getEndNode().isVisited())
				{
					outArcs[i].getEndNode().setVisited();
					queue.add(new Element(outArcs[i].getEndNode()));
					result.add(new Element(outArcs[i].getEndNode()));

					//change view and give us time to see it
					traverse.setXPosition(outArcs[i].getEndNode().getXPosition());
					traverse.setYPosition(outArcs[i].getEndNode().getYPosition());
					arena.update();
					graphWait(5000);
				}
			}					
			
		}

		Node[] order = new Node[result.getSize()];
		for(int i=0;i<order.length;i++){
			order[i] = result.remove().getNode();
		}

		//remove visualisation
		arena.removeBall(traverse);
		arena.update();
		
		return order;
	}
	

}