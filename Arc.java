/** the Arc class for the Graph, contains a start node and an end node. 
* Also contains two possible representations for the arc on the GameArena (line and selfArc)
*/
public class Arc
{
	//the nodes at each end of this arc
	private Node startNode;
	private Node endNode;

	//the two possible representations of this arc on the GameArena
	private Line line;
	private Ball[] selfArc = new Ball[2];
	
	//used to distinguish x and y in array containing position. 
	//not changed in code.
	private int X = 0;
	private int Y = 1;
	
	/** constructor - create an Arc
	* @param startNode the node at the beginning of the arc
	* @param endNode the node at the end of the arc
	*/
	public Arc(Node sNode,Node eNode){
		startNode = sNode;
		endNode = eNode;

		//add this arc as an outgoing arc for the start node
		startNode.addArc(this);	

		//make sure arcs in different directions are in slightly different places
		double[] start = {startNode.getXPosition(),startNode.getYPosition()};
		double[] end = {endNode.getXPosition(),endNode.getYPosition()};
					
		//and check for self arc
		if(!isSelfArc())
		{
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
		else{
			double diameter = startNode.getDiameter();
			selfArc[0] = new Ball(start[X]+diameter - 4,start[Y]+diameter-4,diameter+4,startNode.getColour());
			selfArc[1] = new Ball(start[X]+diameter-4,start[Y]+diameter-4,diameter,"BLACK");
		}
	}
	
	/** get method
	* @return start node
	*/
	public Node getStartNode(){
		return startNode;
	}
	/** get method
	* @return end node
	*/
	public Node getEndNode(){
		return endNode;
	}
	
	/** get method
	* @return line associated with this arc on the GameArena
	*/
	public Line getLine(){
		return line;
	}
	
	/** get method
	* @return array of two Balls that represent a self arc
	*/
	public Ball[] getSelfArc(){
		return selfArc;
	}
	/** test for self arc
	* @return true if this arc is a self arc
	*/
	public boolean isSelfArc(){
		return startNode.equals(endNode);
	}
	
	/** textual display of this arc's details
	*/
	public void display(){
		System.out.println("arc: from "+startNode.getName()+" to "+endNode.getName());
	}


}