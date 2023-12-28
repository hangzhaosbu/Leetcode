class TrieNode{
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

class WordDictionary {
public:
    TrieNode* root = new TrieNode();
    WordDictionary() {
        
    }
    
    void addWord(string word) {
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
    
    bool dfs(int i, TrieNode* cursor, string word)
    {
        if(i == word.length()) return cursor->isWord;
        
        if(word[i] == '.')
        {
            bool valid = false;
            for(int j = 0; j < 26; j++)
            {
                if(cursor->next[j] != nullptr)
                {
                    if(dfs(i + 1, cursor->next[j], word))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        else
        {
            if(cursor->next[word[i] - 'a'] != nullptr)
                return dfs(i + 1, cursor->next[word[i] - 'a'], word);
            else
            {
                return false;
            }
        }
    }
    
    bool search(string word) {
        TrieNode* cursor = root;
        return dfs(0, cursor, word);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */