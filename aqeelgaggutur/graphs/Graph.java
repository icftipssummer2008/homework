import java.util.*;

public class Graph {
    private Map<Integer,LinkedList<Integer>> adjacencyList;
    public Graph() {
        this.adjacencyList = new HashMap<Integer, LinkedList<Integer>>();
    }

    public void addEdge(int u, int v) {
    	LinkedList<Integer> list;
    	if(this.adjacencyList.get(u) == null) {
    		list = new LinkedList<>();
    		list.add(v);
    		adjacencyList.put(u, list);
    	} else {
    		list = this.adjacencyList.get(u);
    		list.add(v);
    	}
    }

    public void printGraphUsingBFS() {

    }

    public void printGraphUsingDFS() {
    	HashSet<Integer> seen = new HashSet<>();
    	System.out.print("DFS Search: ");
    	for (int key : this.adjacencyList.keySet()) {
    	    this.DFSHelper(key, seen);
    	}
    }
    
    public void DFSHelper(int key, Set<Integer> seen) {
    	if(!seen.contains(key)) {
    		System.out.print(key + " ");
    		seen.add(key);
    		if(this.adjacencyList.get(key) != null) {
    			List<Integer> list = this.adjacencyList.get(key);
    			for(int i = 0; i < list.size(); i++) {
        			this.DFSHelper(list.get(i), seen);
        		}
    		}
    	}
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 7);
        g.addEdge(2, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 10);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(3,5);
        g.addEdge(3, 6);
        
        g.printGraphUsingDFS();
    }
}