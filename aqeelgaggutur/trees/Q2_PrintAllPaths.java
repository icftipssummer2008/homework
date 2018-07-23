public class PrintAllPaths{
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return new ArrayList<String>();
		Stack<Integer> s = new Stack();
		ArrayList<String> l = new ArrayList();
		treePathHelper(root, l, s);
		return l;
	}

	public void treePathHelper(TreeNode root, ArrayList<String> l, Stack<Integer> s){
		if(root == null) return;
		s.push(root.val);
		if(root.left == null && root.right == null) addToList(l, s);
		treePathHelper(root.left, l, s);
		treePathHelper(root.right, l, s);
		s.pop();
	}

	public void addToList(ArrayList<String> l, Stack<Integer> s){
		StringBuilder a = new StringBuilder();
		for(Integer i : s){
			a.append(i + "->");
		}
		a.deleteCharAt(a.length() - 1);
		a.deleteCharAt(a.length() - 1);
		l.add(a.toString());
	}
}

