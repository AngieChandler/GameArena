/** the Arc class for the Graph, contains a start node and an end node. 
* Also contains two possible representations for the arc on the GameArena (line and selfArc)
*/
public class TreeArc
{
	//the nodes at each end of this arc
	private TreeNode startNode;
	private TreeNode endNode;
	private boolean success = false;

	//the representation of this arc on the GameArena
	private Line line;
	
	//used to distinguish x and y in array containing position. 
	//not changed in code.
	private int X = 0;
	private int Y = 1;
	
	/** constructor - create an Arc
	* @param startNode the node at the beginning of the arc
	* @param endNode the node at the end of the arc
	*/
	public TreeArc(TreeNode sNode,TreeNode eNode){
		startNode = sNode;
		endNode = eNode;

		//add this arc as the incoming arc for the end node
		boolean success = endNode.addArc(this);	

		this.success = success;
		
		if(success)
			makeArc();

	}


	private void makeArc()
	{
		//make sure arcs in different directions are in slightly different places
		double[] start = {startNode.getXPosition(),startNode.getYPosition()};
		double[] end = {endNode.getXPosition(),endNode.getYPosition()};
					
		if(start[X]<end[X]){
			start[Y]+=2;
			end[Y]+=2;
		}
		else{
			start[Y]-=2;
			end[Y]-=2;
		}
		
		line = new Line(start[X],start[Y],end[X],end[Y],2,startNode.getColour());

	}

	
	/** get method
	* @return start node
	*/
	public TreeNode getStartNode(){
		return startNode;
	}
	/** get method
	* @return end node
	*/
	public TreeNode getEndNode(){
		return endNode;
	}
	
	/** get method
	* @return line associated with this arc on the GameArena
	*/
	public Line getLine(){
		return line;
	}
	
	public boolean getSuccess(){
		return success;
	}
	
	//changes line colour for now, but doesn't store in arc (so can be reset)
	public void setTempLineColour(String colour){
		line.setColour(colour);
	}
	
	/** textual display of this arc's details
	*/
	public void display(){
		System.out.println("arc: from "+startNode.getName()+" to "+endNode.getName());
	}


}