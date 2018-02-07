/*
Stack class using Element class to form a chain. 
Note - data and next are private in Element so use getters and setters
*/
public class Stack
{
	private Element top = null;
	private Element bottom = null;
	private int size = 0;
	
	public Stack(){

	}


	public void push(Element element){
		if(top == null)
			top = element;
		else{
			element.setNext(top);
			top = element;
		}
		size++;
	}
	
	public Element pop(){
		if(top == null)
			System.out.println("stack empty");
		else{
			size--;
			Element element = top;
			top = top.getNext();
			return element;
		}
		return null;
	}

	public void printStack(){
		System.out.println("STACK  INFO");
		if(top!=null)
			System.out.print("Top = "+top.getNode().getName()+", ");
		if(bottom!=null)
			System.out.print("Bottom = "+bottom.getNode().getName()+", "); 
		System.out.println("size = "+size+"\nContent: ");
		
		Element element = top;
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
		new Stack();
	}
}