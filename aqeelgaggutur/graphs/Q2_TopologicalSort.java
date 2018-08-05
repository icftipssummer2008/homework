public void AlienDictionary(String[] words) {
    CharacterGraph g = new CharacterGraph();
    this.createGraph(words, g);
    g.printTopologicalSortGraph(g);
}

public void createGraph(String[] words, CharacterGraph g) {
    if(words.length == 0) return;
    int letter = 0;
    int maxLetter = 0;
    for(int i = 1; i < words.length; i++){
        maxLetter = Math.min(words[i-1].length(), words[i].length());
        letter = 0;
        for(int j = 0; j < maxLetter;j++) {
                if(words[i-1].charAt(letter) == words[i].charAt(letter)){
                letter++;
            } else {
                g.addEdge(words[i-1].charAt(letter), words[i].charAt(letter));
                break;
            }
        }
    }
}

public void printTopologicalSortGraph(CharacterGraph g) {
    Map<Character,LinkedList<Character>> adjacencyList = g.getAdjacencyList();
}