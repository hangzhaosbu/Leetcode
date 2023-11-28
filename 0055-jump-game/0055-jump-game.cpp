class Solution {
public:
    bool canJump(vector<int>& nums) {
        int MAX = 0;
        
        for(int i = 0; i < nums.size(); i++)
        {
            if(i <= MAX)
            {
                MAX = max(MAX, i + nums[i]);
            }
        }
        
        return MAX >= nums.size() - 1;
    }
};