public class ValidBST{
	public boolean isValidBST(TreeNode root) {
		return getTreeVals(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean getTreeVals(TreeNode root, long min, long max){
		if(root == null) return true;

		if(root.val <= min || root.val >= max) return false;
		return getTreeVals(root.left, min, root.val) && getTreeVals(root.right, root.val, max);
	}

}