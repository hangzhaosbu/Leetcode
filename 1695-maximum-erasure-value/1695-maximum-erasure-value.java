class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        int j = 0, N = nums.length;
        hashset.add(nums[0]);
        int curt = nums[0];
        int result = 0;
        for(int i = 0; i < N; ++i)
        {
            while(j + 1 < N && !hashset.contains(nums[j + 1]))
            {
                hashset.add(nums[j + 1]);
                curt += nums[j + 1];
                j ++;
            }
            
            
            result = Math.max(result, curt);
            
            hashset.remove(nums[i]);
            curt -= nums[i];
        }
        
        return result;
    }
}