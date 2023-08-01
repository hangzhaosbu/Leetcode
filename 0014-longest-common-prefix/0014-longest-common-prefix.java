class TrieNode 
{
    int val;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode()
    {
        this.val = 0;
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class Solution {
    TrieNode root = new TrieNode();
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
            {
                return false;
            }
            node = node.children[c - 'a'];
        }
        
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null)
            {
                return false;
            }
            node = node.children[c - 'a'];
        }
        
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        int minlen = Integer.MAX_VALUE;
        for(String str: strs)
        {
            if(str.equals("")) return "";
            minlen = Math.min(minlen, str.length());
            insert(str);
        }
        
        TrieNode node = root;
        String result = "";
        
        while(node != null)
        {
            int size = 0;
            int count = 0;
            int idx = 0;
            
            for(int i = 0; i < 26; i++)
            {
                
                if(node.children[i] != null)
                {
                    size++;
                    idx = i;
                }
            }
            
            if(size == 1 && result.length() < minlen)
            {
                result += (char) ((int) 'a' + idx);
                node = node.children[idx];
            }
            else
            {
                break;
            }
        }
        
        return result;
    }
}