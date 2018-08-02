public boolean isCyclic(int[][] graph) {
    for(int i = 0; i < graph.length; i++){
        Set<Integer> s = new HashSet<>();
        if(cycleHelper(graph, i, s)) return true;
    }
    return false;
}

public boolean cycleHelper(int[][] graph, int node, Set<Integer> s) {
    if(s.contains(node)) return true;
    
    s.add(node);
    for(int i =0; i < graph[node].length; i++) {
        if(cycleHelper(graph, graph[node][i], s)) return true;
    }
    s.remove(node);
    return false;
}