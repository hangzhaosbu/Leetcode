class TrieNode
{
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode()
    {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie
{
    private TrieNode root;
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    public void addWord(String word)
    {
        int N = word.length();
        TrieNode node = root;
        
        for(int i = 0; i < N; ++i)
        {
            if(node.children[word.charAt(i) - 'a'] == null)
            {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        
        node.isWord = true;
    }
    
    public boolean search(String word)
    {
        int N = word.length();
        TrieNode node = root;
        return dfs(word, 0, N, node);
    }
    
    public boolean dfs(String word, int pos, int N, TrieNode node)
    {
        if(pos == N)
        {
            return node.isWord;
        }
        
        Character c = word.charAt(pos);
        
        if(c == '.')
        {
            for(int i = 0; i < 26; ++i)
            {
                if(node.children[i] != null && dfs(word, pos + 1, N, node.children[i]))
                {
                    return true;
                }
            }
            
            return false;
        }
        else
        {
            if(node.children[c - 'a'] == null)
            {
                return false;
            }
            return dfs(word, pos + 1, N, node.children[c - 'a']);
        }
    }
}

class WordDictionary
{
    Trie trie;

    public WordDictionary()
    {
        trie = new Trie();
    }
    
    public void addWord(String word)
    {
        trie.addWord(word);
    }
    
    public boolean search(String word)
    {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */