class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int prev = 1;
        //1   1  2  6
        //24 12  4  1
        
        vector<int> result(nums.size(), 0);
        
        for(int i = 0; i < nums.size(); i++)
        {
            result[i] = prev;
            prev *= nums[i];
        }
        
        prev = 1;
        for(int i = nums.size() - 1; i >= 0; i--)
        {
            result[i] *= prev;
            prev *= nums[i];
        }
        
        return result;
    }
};