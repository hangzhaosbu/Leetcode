class Solution {
public:
    string ans = "";
    
    string findDifferentBinaryString(vector<string>& nums) {
        set<string> hashset;
        
        for(auto num : nums) hashset.insert(num);
        
        int size = nums[0].length();
        string s[2] = {"0", "1"};
        
        dfs("", size, s, hashset);
        
        return ans;
    }
    
    void dfs(string curt, int size, string s[], set<string>& hashset)
    {
        if(curt.length() == size)
        {
            if(hashset.find(curt) == hashset.end()) ans = curt;
            return;
        }
        
        for(int i = 0; i < 2; i++)
        {
            dfs(curt + s[i], size, s, hashset);
        }
    }
};