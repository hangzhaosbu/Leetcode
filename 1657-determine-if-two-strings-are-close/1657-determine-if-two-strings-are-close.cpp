class Solution {
public:
    int word1c[26];
    int word2c[26];
    bool closeStrings(string word1, string word2) {
        for(auto& c : word1)
        {
            word1c[c - 'a']++;
        }
        for(auto& c : word2)
        {
            word2c[c - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(word1c[i] != 0 && word2c[i] == 0 || word1c[i] == 0 && word2c[i] != 0) return false;
        }
        
        for(int i = 0; i < 26; i++)
        {
            for(int j = 0; j < 26; j++)
            {
                if(word1c[i] != 0 && word1c[i] == word2c[j])
                {
                    word1c[i] = 0;
                    word2c[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(word1c[i] != 0 || word2c[i] != 0) return false;
        }
        
        return true;
    }
};