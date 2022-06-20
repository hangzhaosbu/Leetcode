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
        
        if(row < 0 || row >= N || col < 0 || col >= M || visited.contains(row * M + col))
        {
            return;
        }
        
        if(root.children[board[row][col] - 'a'] != null)
        {
            visited.add(row * M + col);
            str.append(board[row][col]);
            
            dfs(row + 1, col, N, M, board, root.children[board[row][col] - 'a'], str, visited);
            dfs(row - 1, col, N, M, board, root.children[board[row][col] - 'a'], str, visited);
            dfs(row, col + 1, N, M, board, root.children[board[row][col] - 'a'], str, visited);
            dfs(row, col - 1, N, M, board, root.children[board[row][col] - 'a'], str, visited);
            
            str.deleteCharAt(str.length() - 1);
            visited.remove(row * M + col);
        }
    }
    
    public List<String> findWords(char[][] board, String[] words)
    {
        result = new HashSet<>();
        Trie trie = new Trie();
        HashSet<Integer> visited = new HashSet<>();
        int N = board.length, M = board[0].length;
        
        for(String word : words)
        {
            trie.addWord(word);
        }
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