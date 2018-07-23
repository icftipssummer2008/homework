public class PostOrder{
	public void postOrder(Node root){

	}

	public void postOrderRecurstion(Node root){
		if(root == null) return;

		postOrderRecurstion(root.left);
		postOrderRecurstion(root.right);
		System.out.println(root.val);
	}
}