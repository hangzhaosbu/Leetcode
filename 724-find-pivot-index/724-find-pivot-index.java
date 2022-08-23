class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, count = 0;
        
        for(int num : nums)
        {
            sum+=num;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            count+= i >= 1 ? nums[i - 1] : 0;
            sum -= i >= 1 ? nums[i - 1] : 0;
            
            if(sum - nums[i] == count)
            {
                return i;
            }
        }
        
        return -1;
    }
}