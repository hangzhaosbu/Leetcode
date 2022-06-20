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
    TrieNode root;
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    public void addWord(String word)
    {
        TrieNode node = root;
        int N = word.length();
        
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
}

class Solution 
{
    private HashSet<String> result;
    
    private void dfs(int row, int col, int N, int M, char[][] board, TrieNode root, StringBuilder str, HashSet<Integer> visited)
    {
        if(root.isWord)
        {
            result.add(str.toString());
            root.isWord = false;
        }
        
        
        if(row < 0 || row >= N || col < 0 || col >= M)
        {
            return;
        }
        
        if(visited.contains(row * M + col))
        {
            return;
        }
        
        visited.add(row * M + col);
        if(root.children[board[row][col] - 'a'] != null)
        {
            char curt = board[row][col];
            str.append(curt);
            
            dfs(row + 1, col, N, M, board, root.children[curt - 'a'], str, visited);
            dfs(row - 1, col, N, M, board, root.children[curt - 'a'], str, visited);
            dfs(row, col + 1, N, M, board, root.children[curt - 'a'], str, visited);
            dfs(row, col - 1, N, M, board, root.children[curt - 'a'], str, visited);
            
            str.deleteCharAt(str.length() - 1);
        }
        
        visited.remove(row * M + col);
    }
    
    public List<String> findWords(char[][] board, String[] words)
    {
        result = new HashSet<>();
        Trie trie = new Trie();
        HashSet<Integer> visited = new HashSet<>();
        
        for(String word : words)
        {
            trie.addWord(word);
        }
        
        int N = board.length, M = board[0].length;
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                dfs(i, j, N, M, board, trie.root, new StringBuilder(), visited);
            }
        }
        
        return new ArrayList<>(result);
    }
}

