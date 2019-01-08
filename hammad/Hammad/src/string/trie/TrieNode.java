package string.trie;

public class TrieNode {
	
	final private int MAX_CHARS = 26;

	private TrieNode[] links;
	private boolean end;
	
	public TrieNode() {
		links = new TrieNode[MAX_CHARS];
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

	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
