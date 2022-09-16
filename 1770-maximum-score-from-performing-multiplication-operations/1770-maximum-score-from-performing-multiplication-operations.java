class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        
        for (int op = m - 1; op >= 0; op--) {
            int[] next_row = dp.clone();
            // Present Row is now next_Row because we are moving upwards
            for (int left = op; left >= 0; left--) {
                dp[left] = Math.max(multipliers[op] * nums[left] + next_row[left + 1],
                                   multipliers[op] * nums[n - 1 - (op - left)] + next_row[left]);
            }
        }
        
        return dp[0];
    }
}