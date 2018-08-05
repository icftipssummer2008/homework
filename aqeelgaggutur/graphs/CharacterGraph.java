import java.util.*;

public class CharacterGraph {
    private Map<Character,LinkedList<Character>> adjacencyList;
    public CharacterGraph() {
        this.adjacencyList = new HashMap<Character, LinkedList<Character>>();
    }

    public void addEdge(char u, char v) {
        LinkedList<Character> list;
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
        HashSet<Character> seen = new HashSet<>();
        System.out.print("BFS Search: ");
        for (char key : this.adjacencyList.keySet()) {
            this.BFSHelper(key, seen);
        }
        System.out.println();
    }

    private void BFSHelper(char key, Set<Character> seen) {
        Queue<Character> q = new LinkedList<>();
        q.add(key);
        while(!q.isEmpty()) {
            if(this.adjacencyList.get(key) != null) {
                List<Character> list = this.adjacencyList.get(key);
                for(int i = 0; i < list.size(); i++) {
                    if(!seen.contains(list.get(i))) {
                        q.add(list.get(i));
                    }
                }
            }
            char num = q.poll();
            if(!seen.contains(num)) {
                System.out.print(num + " ");
                seen.add(num);
            }
        }
    }

    public void printGraphUsingDFS() {
        HashSet<Character> seen = new HashSet<>();
        System.out.print("DFS Search: ");
        for (char key : this.adjacencyList.keySet()) {
            this.DFSHelper(key, seen);
        }
        System.out.println();
    }

    private void DFSHelper(char key, Set<Character> seen) {
        if(!seen.contains(key)) {
            System.out.print(key + " ");
            seen.add(key);
            if(this.adjacencyList.get(key) != null) {
                List<Character> list = this.adjacencyList.get(key);
                for(int i = 0; i < list.size(); i++) {
                    this.DFSHelper(list.get(i), seen);
                }
            }
        }
    }

    public Map<Character,LinkedList<Character>> getAdjacencyList(){
        return adjacencyList;
    }

    public static void main(String[] args) {

    }
}