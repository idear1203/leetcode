package cn.idear.algorithm.add_and_search_word_data_structure_design;

/**
 * Created by idear on 15-11-2.
 * 见trie
 */
public class WordDictionary {

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.insert(word.toCharArray(), 0, word.length());
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0, word.length());
    }

    class TrieNode{

        boolean isEnd = false;

        TrieNode[] children = new TrieNode[26];

        private TrieNode getChildByKey(char ch){
            int index = ch - 'a';
            if(children[index] == null)
                children[index] = new TrieNode();
            return children[index];
        }

        void insert(char[] words, int start, int length){
            if(length == 0)
                isEnd = true;
            else{
                TrieNode node = getChildByKey(words[start]);
                node.insert(words, start + 1, length - 1);
            }
        }

        boolean search(char[] words, int start, int length){
            if(length == 0)
                return isEnd;
            else if(words[start] == '.'){
                for(TrieNode child : children){
                    if(child != null){
                        if(child.search(words, start + 1, length - 1))
                            return true;
                    }
                }
                return false;
            }else{
                TrieNode child = children[words[start] - 'a'];
                if(child == null) return false;
                return child.search(words, start + 1, length - 1);
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
