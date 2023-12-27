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

class Trie {
public:
    TrieNode* root = new TrieNode();
    Trie() {
        
    }
    
    void insert(string word) {
        TrieNode* cursor = root;
        
        for(auto & c : word)
        {
            if(cursor->next[c - 'a'] == nullptr)
            {
                cursor->next[c - 'a'] = new TrieNode();
            }
            
            cursor = cursor->next[c - 'a'];
        }
        cursor->isWord = true;
    }
    
    bool search(string word) {
        TrieNode* cursor = root;
        
        for(auto & c : word)
        {
            if(cursor->next[c - 'a'] == nullptr)
            {
                return false;
            }
            
            cursor = cursor->next[c - 'a'];
        }
        
        return cursor->isWord;
    }
    
    bool startsWith(string prefix) {
        TrieNode* cursor = root;
        
        for(auto & c : prefix)
        {
            if(cursor->next[c - 'a'] == nullptr)
            {
                return false;
            }
            
            cursor = cursor->next[c - 'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */