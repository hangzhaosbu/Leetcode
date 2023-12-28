class TrieNode {
public:
    bool isWord;
    TrieNode* next[26];
    
    TrieNode()
    {
        this->isWord = false;
        for(int i = 0; i < 26; i++)
        {
            this->next[i] = nullptr;
        }
    }
};

class Solution {
public:
    int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words)
    {
        unordered_set<string> ans;
        TrieNode* root = new TrieNode();
        
        for(auto & word : words)
        {
            TrieNode* cursor = root;
            
            for(auto& c : word)
            {
                if(cursor->next[c - 'a'] == nullptr)
                {
                    cursor->next[c - 'a'] = new TrieNode();
                }
                
                cursor = cursor->next[c - 'a'];
            }
            
            cursor->isWord = true;
        }
        
        int m = board.size(), n = board[0].size();
        
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                
                TrieNode* cursor = root;
                if(cursor->next[board[i][j] - 'a'] != nullptr)
                {
                    vector<vector<bool>> visited(m, vector<bool>(n, false));
                    string s(1, board[i][j]);
                    visited[i][j] = true;
                    dfs(i, j, s, board, cursor->next[board[i][j] - 'a'], ans, visited);
                    visited[i][j] = false;
                }
            }
        }
        vector<string> v(ans.size());
        copy(ans.begin(), ans.end(), v.begin());
        return v;
    }
    
    void dfs(int x, int y, string word, vector<vector<char>>& board, TrieNode* cursor, unordered_set<string>& ans, vector<vector<bool>>& visited)
    {
        if(cursor->isWord && ans.find(word) == ans.end())
        {
            ans.insert(word);
        }
        
        for(auto& direction : directions)
        {
            int newx = x + direction[0];
            int newy = y + direction[1];
            
            if(newx < 0 || newx >= board.size() || newy < 0 || newy >= board[0].size()) continue;
            
            if(cursor->next[board[newx][newy] - 'a'] == nullptr || visited[newx][newy]) continue;
            
            
            visited[newx][newy] = true;
            dfs(newx, newy, word + board[newx][newy], board, cursor->next[board[newx][newy] - 'a'], ans, visited);
            visited[newx][newy] = false;
        }
    }
};