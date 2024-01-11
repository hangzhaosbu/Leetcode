class Solution {
public:
    vector<int> prefixSum;
    Solution(vector<int>& w) {
        int total = 0;
        
        for(auto& num : w)
        {
            total+=num;
            prefixSum.push_back(total);
        }
    }
    
    int pickIndex() {
        float r = (float) rand() / RAND_MAX;
        float target = prefixSum.back() * r;
        
        for(int i = 0; i < prefixSum.size(); i++)
        {
            if(target < prefixSum[i]) return i;
        }
        
        return prefixSum.size() - 1;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */