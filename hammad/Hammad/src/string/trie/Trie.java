package string.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private TrieNode root;
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("important");
		trie.insert("impatient");
		trie.insert("impotent");
		trie.insert("implement");
		trie.insert("indiction");
		
		List<String> suggestions = trie.giveSuggestions("impo");
		for (String str : suggestions) {
			System.out.println(str);
		}
		
	}
	
	public Trie() {
		root = new TrieNode(null);
	}
	
	public void insert(String str) {
		TrieNode node = root;
		for (int i = 0; i <  str.length(); i++) {
			char c = str.charAt(i);
			if(!node.containsKey(c)) {
				node.put(c, new TrieNode(c));
			}
			node = node.get(c);
			
		}
		node.setEnd();
	}
	
	public List<String> giveSuggestions(String str) {
		List<String> list = new ArrayList<>();
		TrieNode node = root;
		
		for (int i = 0; i <  str.length(); i++) {
			char c = str.charAt(i);
			if(node.containsKey(c)) {
				node = node.get(c);
 			}
			else {
				return list;
			}
		}
		
		findRecursive(node, list, str);
		
		
		return list;
	}
	 
	public void findRecursive(TrieNode node, List<String> list  ,String str) {
		if(node == null) {
			return;
		}
		if(node.isEnd()) {
			list.add(str);
		}
		
		TrieNode[] nodes = node.getLinks();
		for (TrieNode trieNode : nodes) {
			String appStr = str;
			if(trieNode != null) {
				appStr = appStr + trieNode.getC();
			}
			findRecursive(trieNode, list, appStr);
		}
		
	}
	
	public TrieNode searchPrefix(String str) {
		TrieNode node = root;
		for (int i = 0; i <  str.length(); i++) {
			char c = str.charAt(i);
			if(node.containsKey(c)) {
				node = node.get(c);
			}
			else {
				return null;
			}			
		}
		return node;
	}
	
	public boolean search(String str) {
		TrieNode trieNode = searchPrefix(str);
		return trieNode != null && trieNode.isEnd();
	}
	
}
