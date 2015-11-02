package cn.idear.algorithm.implement_trie_prefix_tree;

/**
 * Created by idear on 15-11-2.
 */
class TrieNode {
    /**
     * 每个节点有26个子节点。
     */
    TrieNode[] children = new TrieNode[26];

    /**
     * 用于标识最后一个字母，这可以用来区别startWith和search
     */
    boolean isEnd = false;

    // Initialize your data structure here.
    public TrieNode() {

    }

    void insert(char[] word, int start, int length){
        if(length == 0)
            isEnd = true;
        else {
            TrieNode node = getChild(index(word[start]));
            node.insert(word, start + 1, length - 1);
        }
    }

    private TrieNode getChild(int i){
        if(children[i] == null)
            children[i] = new TrieNode();
        return children[i];
    }

    boolean search(char[] word, int start, int length, boolean isStartWith){
        if(length == 0)
            return isStartWith || isEnd;
        TrieNode node = children[index(word[start])];
        if(node == null)
            return false;
        return node.search(word, start + 1, length - 1, isStartWith);
    }

    private int index(char ch){
        return ch - 'a';
    }
}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word.toCharArray(), 0, word.length());
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0, word.length(), false);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix.toCharArray(), 0, prefix.length(), true);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
