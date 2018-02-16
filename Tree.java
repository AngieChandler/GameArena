public class Tree
{
	//the arrays of nodes and arcs that form this tree
	private TreeNode[] nodes;
	private TreeArc[] arcs;
	
	//the GameArena for drawing on
	private GameArena arena;


	public Tree(GameArena a){
		nodes = new TreeNode[0];
		arcs = new TreeArc[0];
		
		arena = a;
	}

	
	public void display(){
		System.out.println("*****************************");
		System.out.println("Tree");
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
	public TreeNode getNode(String name){
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].getName().equals(name))
				return nodes[i];
		}
		return null;
	}
	public TreeArc getArc(String node1,String node2){
		for(int i=0;i<arcs.length;i++){
			if(arcs[i].getStartNode().getName().equals(node1) && arcs[i].getEndNode().getName().equals(node2))
				return arcs[i];
		}
		return null;
	}
	
	public TreeNode[] getNodes(){
		return nodes;
	}
	
	public TreeArc[] getArcs(){
		return arcs;
	}

	/** add a node to the graph, also increases the size of the node array to accommodate the new node
	* @param node the Node to be added to the graph
	*/
	public void addNode(TreeNode node){		
		TreeNode[] oldNode = nodes;
		
		nodes = new TreeNode[oldNode.length+1];
		for(int i=0;i<oldNode.length;i++){
			nodes[i] = oldNode[i];
		}
		nodes[oldNode.length] = node;
	}
	
	/** add an arc to the graph, also increases the size of the arc array to accommodate the new arc
	* @param arc the Arc to be added to the graph
	*/
	public void addArc(TreeArc arc){
		TreeArc[] oldArc = arcs;
		
		arcs = new TreeArc[oldArc.length+1];
		for(int i=0;i<oldArc.length;i++){
			arcs[i] = oldArc[i];
		}
		arcs[oldArc.length] = arc;
	}

	
	/*********************************************************************************************/
	
	/** reset graph drawing, removes all drawing objects from the GameArena
	*/
	public void resetTree(){
		for(int i=0;i<nodes.length;i++){
			arena.removeBall(nodes[i].getDrawnNode());
			arena.removeText(nodes[i].getLabel());
		}
		for(int i=0;i<arcs.length;i++){
			arena.removeLine(arcs[i].getLine());
		}
	}
	
	
	/** graphical only, draws the stored graph on the GameArena
	*/
	public void drawTree(){
		resetTree();
		for(int i=0;i<arcs.length;i++){
			arena.addLine(arcs[i].getLine());
		}	
		for(int i=0;i<nodes.length;i++){
			arena.addBall(nodes[i].getDrawnNode());
			arena.addText(nodes[i].getLabel());
		}
		
	}	
	
	
	
}