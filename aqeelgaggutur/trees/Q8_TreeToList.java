public class TreeToList {
	public Node treeToList(Node root){
		List<Node> l = new LinkedList<Node>();
		getInOrder(root, l);

		// connect first to last
		l.get(0).left = l.get(l.size() - 1);
		l.get(l.size() - 1).right = l.get(0);

		for(int i = 0; i < l.size() - 1; i++){
			if(i != 0){
				l.get(i).left = l.get(i-1);
			}
			l.get(i).right = l.get(i + 1);
		}
		return l.get(0);
	}

	public void getInOrder(Node root, List<Node> l){
		if(root == null) return;

		getInOrder(root.left, l);
		l.add(root);
		getInOrder(root.right, l);
	}
}