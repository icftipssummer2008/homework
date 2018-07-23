public class FlipTree {
	public TreeNode invertTree(TreeNode root) {
		TreeHelp(root);
		return root;
	}

	public void TreeHelp(TreeNode root){
		if(root == null || (root.left == null && root.right == null)) return;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		TreeHelp(root.left);
		TreeHelp(root.right);
	}
}