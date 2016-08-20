import java.util.*;

class TrieNode {
	boolean wordEndsHere;
	TrieNode[] children;
	
	public TrieNode() {
		wordEndsHere = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
        	int index = charLowercaseToInt(word.charAt(i));
        	TrieNode child = cur.children[index];
        	if (child == null)
        	{
        		child  = new TrieNode();
        		cur.children[index] = child;
        	}
        	cur = child;
        }
        cur.wordEndsHere = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode cur = root;
    	for(int i=0;i<word.length();i++)
    	{
    		int index = charLowercaseToInt(word.charAt(i));
        	TrieNode child = cur.children[index];
        	if (child == null)
        		return false;
        	else
        		cur = child;
    	}
    	return cur.wordEndsHere;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
    	for(int i=0;i<prefix.length();i++)
    	{
    		int index = charLowercaseToInt(prefix.charAt(i));
        	TrieNode child = cur.children[index];
        	if (child == null)
        		return false;
        	else
        		cur = child;
    	}
        return true;
    }
    
    private static int charLowercaseToInt(char c)
    {
    	return c - 'a';
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");