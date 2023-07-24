class Solution {
    final int N = (int) 1e5 + 5;
    int[] maxq = new int[N];
    int left = 0, right = 0;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; i++)
        {
            int curt = nums[i];
            while(left != right && maxq[right - 1] < curt)
            {
                right--;
            }
            
            maxq[right++] = curt;
            
            if(i - k >= 0 && nums[i - k] == maxq[left]) left++;;
            
            if(i >= k - 1)
            {
                result[i - k + 1] = maxq[left];
            }
            
            
        }
        
        return result;
    }
}