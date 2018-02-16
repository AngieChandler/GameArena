public class LectureTree
{
	public LectureTree(){
		GameArena arena = new GameArena(1000,800);
		Tree t = new Tree(arena);
		
		System.out.println("Generating Tree");
		
		TreeNode node = new TreeNode(500,150,30,"RED","A");
		t.addNode(node);
		node = new TreeNode(400,300,30,"BLUE","B");
		t.addNode(node);
		node = new TreeNode(600,300,30,"GREEN","C");
		t.addNode(node);
		node = new TreeNode(350,500,30,"PURPLE","D");
		t.addNode(node);
		node = new TreeNode(450,500,30,"YELLOW","E");
		t.addNode(node);
		node = new TreeNode(550,500,30,"BROWN","F");
		t.addNode(node);
		node = new TreeNode(650,500,30,"TURQUOISE","G");
		t.addNode(node);
		
		TreeArc arc = new TreeArc(t.getNode("A"),t.getNode("B"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("A"),t.getNode("C"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("B"),t.getNode("D"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("B"),t.getNode("E"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("C"),t.getNode("F"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("C"),t.getNode("G"));
		addArc(t,arc);
		
		arc = new TreeArc(t.getNode("C"),t.getNode("E"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("B"),t.getNode("F"));
		addArc(t,arc);
		arc = new TreeArc(t.getNode("D"),t.getNode("E"));
		addArc(t,arc);

		t.drawTree();
		arena.update();
		t.display();
	
	}
	
	//this allows the program to test if this arc would form a tree, and rejects those that would
	//prints error message.
	private void addArc(Tree t, TreeArc arc){
		if(arc.getSuccess())
			t.addArc(arc);
		else
			System.out.println("failed to add arc "+arc.getStartNode().getName()+"-"+arc.getEndNode().getName()+", would produce graph");		
	}
}