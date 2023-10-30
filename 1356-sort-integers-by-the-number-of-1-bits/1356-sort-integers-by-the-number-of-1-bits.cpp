class Solution {
public:
    int countBits(int num)
    {
        int count = 0;
        for(int i = 0; i < 32; i++)
        {
            if((num >> i) & 1) count++;
        }
        
        return count;
    }
    
    vector<int> sortByBits(vector<int>& arr) {
        int N = 10010;
        vector<int> count[32];
        
        for(auto num : arr)
        {
            int c = countBits(num);
            count[c].push_back(num);
        }
        
        vector<int> ans;
        
        for(int i = 0; i < 32; i++)
        {
            vector<int> curt = count[i];
            sort(curt.begin(), curt.end());
            
            for(auto n : curt)
            {
                ans.push_back(n);
            }
        }
        
        return ans;
    }
};