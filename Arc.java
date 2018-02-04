public class Arc
{
	Node startNode;
	Node endNode;
	
	public Arc(Node startNode,Node endNode){
		this.startNode = startNode;
		this.endNode = endNode;
		
		startNode.addArc(this);	
	}

	public Node getStartNode(){
		return startNode;
	}
	public Node getEndNode(){
		return endNode;
	}
	
	public void display(){
		System.out.println("arc: from "+startNode.getName()+" to "+endNode.getName());
	}


}