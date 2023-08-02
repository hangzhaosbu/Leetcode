class TrieNode 
{
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
            {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        
        node.isWord = true;
    }
    
    private boolean dfs(int j, TrieNode curt, String word)
    {
        TrieNode node = curt;
        for(int i = j; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(c == '.')
            {
                for(int k = 0; k < 26; k++)
                {
                    if(node.children[k] != null && dfs(i + 1, node.children[k], word)) return true;
                }
                return false;
            }
            else if(node.children[c - 'a'] == null) return false;
            
            node = node.children[c - 'a'];
        }
        
        return node.isWord;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return dfs(0, node, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */