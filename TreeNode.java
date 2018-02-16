public class TreeNode
{
	private String name;
	private TreeArc inArc = null;

	//the representation of the node in the GameArena, and its label
	private Ball drawnNode;
	private Text label;
	private boolean visited = false;


	/** constructor - initialise node - including making the instance of Ball to be used on the GameArena
	* @param x int x position
	* @param y int y position
	* @param size int diameter of the ball (in pixels)
	* @param colour String, for details see docs on Ball
	* @param name String, the label for this node
	*/
	public TreeNode(int x,int y, int size, String colour, String n)
	{
		drawnNode = new Ball(x,y,size,colour);
		name = n;
		double textChange = (double)size/4.0;
		label = new Text(n,x-textChange,y+textChange,size,"WHITE");
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
		if(inArc != null)
			System.out.println("in arc: from "+inArc.getStartNode().getName());
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

	public TreeArc getArc(){
		return inArc;
	}
	public boolean addArc(TreeArc arc){
		if(inArc == null){
			inArc = arc;
			return true;
		}
		return false;
	}
	
	/** get method
	* @return the label of this node
	*/
	public Text getLabel(){
		return label;
	}
	public void setVisited(){
		visited = true;
	}
	public void resetVisited(){
		visited = false;
	}
	public boolean isVisited(){
		return visited;
	}




}