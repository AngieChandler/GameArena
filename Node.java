/** Node class, stores an individual node and its out going arcs. Also stores its representation on the GameArena
*/
public class Node
{
	//the arcs leaving this node, and the node's name
	private Arc[] outArcs;
	private String name;

	//the representation of the node in the GameArena
	private Ball drawnNode;

	/** constructor - initialise node - including making the instance of Ball to be used on the GameArena
	* @param x int x position
	* @param y int y position
	* @param size int diameter of the ball (in pixels)
	* @param colour String, for details see docs on Ball
	* @param name String, the label for this node
	*/
	public Node(int x,int y, int size, String colour, String n)
	{
		drawnNode = new Ball(x,y,size,colour);
		name = n;
		
		outArcs = new Arc[0];
	}

	/** get method for the GameArena representation of the node 
	* @return a Ball instance
	*/
	public Ball getDrawnNode(){
		return drawnNode;
	}

	/** display the contents of the node
	*/
	public void display(){
		System.out.println("node: "+name+", at "+drawnNode.getXPosition()+","+drawnNode.getYPosition()+", colour "+drawnNode.getColour());
		if(outArcs.length > 0)
			System.out.println("out arcs:");
		for(int i=0;i<outArcs.length;i++)
			System.out.println("to "+outArcs[i].getEndNode().getName());
	}

	/** get method 
	* @return node name 
	*/
	public String getName(){
		return name;
	}
	/** get method
	* @return the String representing the colour on the Ball (node representation)
	*/
	public String getColour(){
		return drawnNode.getColour();
	}
	
	/** get method
	* @return x position
	*/
	public double getXPosition(){
		return drawnNode.getXPosition();
	}
	/** get method
	* @return y position
	*/
	public double getYPosition(){
		return drawnNode.getYPosition();
	}
	
	/** get method
	* @return the diameter of the node's representation Ball
	*/
	public double getDiameter(){
		return drawnNode.getSize();
	}
	/** get method
	* @return the array of arcs leaving this node
	*/
	public Arc[] getOutArcs(){
		return outArcs;
	}

	/** add an arc to the node's outArc array
	* @param arc the new Arc
	*/
	public void addArc(Arc arc){
		Arc[] oldArc = outArcs;
		
		outArcs = new Arc[oldArc.length+1];
		for(int i=0;i<oldArc.length;i++){
			outArcs[i] = oldArc[i];
		}
		outArcs[oldArc.length] = arc;
	}


}