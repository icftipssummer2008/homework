public class PostOrder{
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> l = new LinkedList<Integer>();
        if(root == null) return l;
        Stack<TreeNode> s = new Stack();
		s.push(root);
		while(!s.empty()){
			TreeNode curr = s.pop();
			l.add(0, curr.val);
			if(curr.left != null){
				s.push(curr.left);
			}
			if(curr.right != null){
				s.push(curr.right);
			}
		}
		return l;
    }

	public void postOrderRecurstion(TreeNode root){
		if(root == null) return;

		postOrderRecurstion(root.left);
		postOrderRecurstion(root.right);
		System.out.println(root.val);
	}
}