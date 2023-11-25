class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        vector<int> prefixSum;
        vector<int> result;
        prefixSum.push_back(0);
        
        int total = 0;
        
        for(int i = 0; i < nums.size(); i++)
        {
            total += nums[i];
            prefixSum.push_back(total);
        }
        
        //0 2 5 10
        for(int i = 0; i < nums.size(); i++)
        {
            int leftSum = prefixSum[i];
            int leftCount = i;
            int rightSum = prefixSum[prefixSum.size() - 1] - prefixSum[i + 1];
            int rightCount = prefixSum.size() - 1 - i - 1;
            
            result.push_back((leftCount * nums[i] - leftSum) + (rightSum - nums[i] * rightCount));
        }
        
        return result;
    }
};