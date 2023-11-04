class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        set<int> hashset;
        vector<int> ans;
        
        for(auto& num : nums)
        {
            hashset.insert(num);
        }
        
        for(int i = 1; i <= nums.size(); i++)
        {
            if(hashset.find(i) == hashset.end())
            {
                ans.push_back(i);
            }
        }
        
        return ans;
    }
};