class Solution {
public:
    bool valid(vector<int>& result, int k)
    {
        for(int i = 1; i < k; i++)
        {
            if(result[i] != result[i - 1]) return false;
        }
        return true;
    }
    
    bool canPartitionKSubsets(vector<int>& nums, int k) 
    {
        int total = 0;
        for(auto num : nums) total += num;
        if(total % k != 0) return false;
        vector<int> result(k, 0);
        
        sort(nums.begin(), nums.end(), greater<int>());
        return dfs(0, k, total / k, nums, result);
    }
    
    bool dfs(int start, int k, int goal, vector<int>& nums, vector<int>& result)
    {
        if(start == nums.size())
        {
            if(valid(result, k)) return true;
            else return false;
        }
        
        for(int i = 0; i < k; i++)
        {
            if(result[i] + nums[start] > goal) continue;
            if(i > 0 && result[i] == result[i - 1]) continue;
            
            result[i] += nums[start];
            if(dfs(start + 1, k, goal, nums, result)) return true;
            result[i] -= nums[start];
        }
        
        return false;
    }
};