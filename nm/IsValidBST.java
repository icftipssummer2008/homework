public class IsValidBST {

	public static void main(String[] args){


		System.out.println("Result:"+isValidBST(null));
	}

	public static boolean isValidBST(TreeNode node) {
		return isValidBST(node,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode node, long min, long max) {
		if(node == null) return true;
		if(node.left != null || node.left.val > node.val || node.val > min  ) return false;
		if(node.right != null || node.right.val < node.val || node.val <min ) return false;
		return isValidBST(node.left, min, node.val  ) && isValidBST(node.right, node.val, max );
	}



	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){
			val =x;
		}
	}
}
