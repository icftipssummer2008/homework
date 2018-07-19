import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;


public class PrintPathToLeafs{
  public static void main(String[] args){
    PrintPathToLeafs tree = new PrintPathToLeafs();

    Node n7 = new Node(7,null,null);
    Node n17 = new Node(17,null,null);
    Node n18 = new Node(18,null,null);

    Node n5 = new Node(5,n18,n17);
    Node n6 = new Node(6,n5,n7);
    Node n10 = new Node(10,n6,null);

    //     10
    //  n6
    //n5 n7

    List<String> result = tree.binaryTreePaths(n10);

    //for(String list:result){
            System.out.println(result);
    //}


    //set.forEach(System.out::println);
    //System.out.println("Hello "+tree.binaryTreePaths(n10));
  }

  public List<String> binaryTreePaths(Node node){
    Set set = new LinkedHashSet();
    List<String> result = new ArrayList();
    return binaryTreePaths(node,set,result);
  }

  public List<String> binaryTreePaths(Node node, Set set, List<String> result){
    if(node == null) return result;


    //SELECT
    set.add(node);


    //PROCESS
    if(node.left == null && node.right == null){
      String s = "";
      for(Object n : set){
        s=  s+ (s.isEmpty()?"":"->") + ((Node)n).data;
      }

      result.add(s);
    }
    binaryTreePaths(node.left,set,result);
    binaryTreePaths(node.right,set,result);

    //UNSELECT
    set.remove(node);

    return result;
  }
}
