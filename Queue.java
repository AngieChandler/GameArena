/*
Queue class using Element class to form a chain. 
Note - data and next are private in Element so use getters and setters
*/
public class Queue
{
	private Element front = null;
	private Element back = null;
	private int size = 0;
	
	public Queue(){

		
	}


	public void add(Element element){
		if(front == null)
			front = element;
		else
			back.setNext(element);
		back = element;
		size++;
	}
	
	public Element remove(){
		if(front == null)
			System.out.println("queue empty");
		else{
			size--;
			Element element = front;
			front = front.getNext();
			return element;
		}
		return null;
	}

	public void printQueue(){
		System.out.println("QUEUE INFO");
		if(front!=null)
			System.out.print("Front = "+front.getNode().getName()+", ");
		if(back!=null)
			System.out.print("Back = "+back.getNode().getName()+", "); 
		System.out.println("size = "+size+"\nContent: ");
		
		Element element = front;
		while(element != null){
			System.out.print(element.getNode().getName()+", ");
			element = element.getNext();
		}
		System.out.println();
		System.out.println();			
	}

	
	public boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}
	
	public int getSize(){
		return size;
	}
	
	
	//use this if just using queue on its own
	public static void main(String[] args){
		new Queue();
	}
}