class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int m = -1;
        vector<int> ans(arr.size(), 0);
        
        for(int i = arr.size() - 1; i >= 0; i--)
        {
            ans[i] = m;
            m = max(m, arr[i]);
        }
        
        return ans;
    }
};