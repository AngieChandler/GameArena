public class Node
{
	Arc[] outArcs;
	Ball drawnNode;
	String name;

	public Node(int x,int y, int size, String colour, String name)
	{
		drawnNode = new Ball(x,y,size,colour);
		this.name = name;
		
		outArcs = new Arc[0];
	}

	public Ball getDrawnNode(){
		return drawnNode;
	}
	
	public void display(){
		System.out.println("node: "+name+", at "+drawnNode.getXPosition()+","+drawnNode.getYPosition()+", colour "+drawnNode.getColour());
		if(outArcs.length > 0)
			System.out.println("out arcs:");
		for(int i=0;i<outArcs.length;i++)
			System.out.println("to "+outArcs[i].getEndNode().getName());
	}
	
	public String getName(){
		return name;
	}
	
	public void addArc(Arc arc){
		int i=0;
		while(i<outArcs.length && outArcs[i]!=null){
			i++;
		}
		if(i<outArcs.length){
			outArcs[i] = arc;
			return;
		}
		
		Arc[] oldArc = outArcs;
		
		outArcs = new Arc[oldArc.length+1];
		for(i=0;i<oldArc.length;i++){
			outArcs[i] = oldArc[i];
		}
		outArcs[oldArc.length] = arc;
	}


}