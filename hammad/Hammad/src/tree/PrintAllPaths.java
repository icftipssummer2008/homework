package tree;

public class PrintAllPaths {
	public static void main(String[] args) {
		Node node = new Node(10);
        
        node.left 		= new Node(8);
        node.right 		= new Node(2);
        node.left.left 	= new Node(3);
        node.left.right = new Node(5);
        node.right.left = new Node(2);
        
        int[] array = new int[50];
		process(node, array, 0);
	}
	
	static void printQueue(int[] array, int length) {
		for (int i = 0; i < length ; i++) {
			System.out.print(array[i]  + " ");
		}
		System.out.println("=======");
	}
	
	
	static void  process(Node currentNode, int[] array, int length) {
		if(currentNode == null) {
			return;
		}
		array[length++] =  currentNode.value;
		
		if(currentNode.left == null && currentNode.right == null) {
			printQueue(array, length);
		}
		else {
			process(currentNode.left, array, length);
			process(currentNode.right, array, length);
		}
	}
}
