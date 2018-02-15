public class SpecialNode
{
	private Node node;
	private Arc inArc;
	private int distance;

	public SpecialNode(Node node,Arc inArc)
	{
		this.node = node;
		this.inArc = inArc;
	}

	public Node getNode(){
		return node;
	}
	
	public Arc getArc(){
		return inArc;
	}

	public Ball getDrawnNode(){
		return node.getDrawnNode();
	}
	
	public Line getLine(){
		return inArc.getLine();
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	public int getDistance(){
		return distance;
	}

	public Text getLabel(){
		return node.getLabel();
	}
	
	public String getName(){
		return node.getName();
	}
}