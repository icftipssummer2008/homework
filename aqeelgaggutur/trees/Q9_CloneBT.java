public class CloneBT{
	public Node cloneBT(Node root){
		Node newRoot;
		cloneHelp(root, newRoot);
		return newRoot;
	}

	public void cloneHelp(Node root, Node newRoot){
		if(root == null) return;

		newRoot = new Node(root.val);
		cloneHelp(root.left, newRoot.left);
		cloneHelp(root.right, newRoot.right);
	}
}