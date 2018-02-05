public class Arc
{
	private Node startNode;
	private Node endNode;

	private Line line;
	private Ball[] selfArc = new Ball[2];
	
	private final int X = 0;
	private final int Y = 1;
	
	public Arc(Node startNode,Node endNode){
		this.startNode = startNode;
		this.endNode = endNode;
		
		startNode.addArc(this);	
		
		double[] start = {startNode.getXPosition(),startNode.getYPosition()};
		double[] end = {endNode.getXPosition(),endNode.getYPosition()};
			
		
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
			line = null;
			double diameter = startNode.getDiameter();
			selfArc[0] = new Ball(start[X]+diameter - 4,start[Y]+diameter-4,diameter+4,startNode.getColour());
			selfArc[1] = new Ball(start[X]+diameter-4,start[Y]+diameter-4,diameter,"BLACK");
		}
	}
	
	
	public Node getStartNode(){
		return startNode;
	}
	public Node getEndNode(){
		return endNode;
	}
	
	public Line getLine(){
		return line;
	}
	public Ball[] getSelfArc(){
		return selfArc;
	}
	public boolean isSelfArc(){
		return startNode.equals(endNode);
	}
	
	public void display(){
		System.out.println("arc: from "+startNode.getName()+" to "+endNode.getName());
	}


}