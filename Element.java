
public class Element
{
	private Element next; 
	private Element prev;
	private Node node;
	
	public Element(Node node){
		this.node = node;
	}

	
	public Element getNext(){
		return next;
	}
	public void setNext(Element next){
		this.next = next;
	}
	public Element getPrev(){
		return prev;
	}
	public void setPrev(Element prev){
		this.prev = prev;
	}
	public Node getNode(){
		return node;
	}
	public void setNode(Node n){
		node = n;
	}



}