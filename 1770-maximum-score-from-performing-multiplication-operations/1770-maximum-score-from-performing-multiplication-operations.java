class Solution {
    
    int[][] memo;
    
    public int topdown(int left, int right, int idx, int[] nums, int[] multipliers)
    {
        if(memo[left][idx] != Integer.MAX_VALUE)
        {
            return memo[left][idx];
        }
        
        if(idx == multipliers.length - 1)
        {
            memo[left][idx] = Math.max(nums[left] * multipliers[idx], nums[right] * multipliers[idx]);
            return memo[left][idx];
        }
        
        memo[left][idx] = Math.max(nums[left] * multipliers[idx] + topdown(left + 1, right, idx + 1, nums, multipliers), nums[right] * multipliers[idx] + topdown(left, right - 1, idx + 1, nums, multipliers));
        
        return memo[left][idx];
    }
    
    public int maximumScore(int[] nums, int[] multipliers) 
    {
        int left = 0, right = nums.length - 1;
        memo = new int[nums.length + 1][multipliers.length + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        return topdown(left, right, 0, nums, multipliers);
    }
}