class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        int maxV = -1;
        vector<int> ans;
        
        for(int i = heights.size() - 1; i >= 0; i--)
        {
            if(heights[i] > maxV)
            {
                ans.push_back(i);
            }
            
            maxV = max(maxV, heights[i]);
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};