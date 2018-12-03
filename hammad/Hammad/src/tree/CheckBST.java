package tree;

public class CheckBST {
	
	public static void main(String[] args) {
		//Node rootNode = BinarySearchTree.getBST();
		Node rootNode = BinaryTree.getBST();
		System.out.println(checkBST(rootNode, null));
		
		rootNode = BinarySearchTree.getBST();
		System.out.println(checkBST(rootNode, null));

	
	}
	
	public static  void printInorder(Node currentNode) {
		if(currentNode == null) {
			return ;
		}
		printInorder(currentNode.left);
		
		System.out.println(currentNode.value);
		
		printInorder(currentNode.right);
	}
	
	public static  boolean checkBST(Node currentNode, Node prev) {
		if(currentNode == null) {
			return true;
		}
		if(!checkBST(currentNode.left, prev)) {
			return false;
		}
		
		if(null != prev && prev.value >= currentNode.value) {
			return false;
		}
		prev = currentNode;
		
		return checkBST(currentNode.right, prev);
	}
}
