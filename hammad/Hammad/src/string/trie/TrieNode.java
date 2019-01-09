package string.trie;

public class TrieNode {
	
	final private int MAX_CHARS = 26;

	private TrieNode[] links;
	private boolean end;
	private Character c;
	
	public TrieNode(Character c) {
		links = new TrieNode[MAX_CHARS];
		this.c = c;
	}
	
	public boolean containsKey(char c) {
		return links[c - 'a'] != null;
	}
	
	public void put(char c, TrieNode node) {
		links[c - 'a'] = node;
	}
	
	public TrieNode get(char c) {
		return links[c - 'a'];
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd() {
		this.end = true;
	}

	public char getC() {
		return c;
	}

	public TrieNode[] getLinks() {
		return links;
	}
	
}
