class Solution {
    public int trap(int[] height) {
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length - 1;
        int result = 0;
        
        while(left <= right)
        {
            int left_height = height[left] , right_height = height[right];
            
            if(left_height < right_height)
            {
                result += Math.max(Math.min(max_left, max_right) - left_height, 0);
                max_left = Math.max(max_left, left_height);
                max_right = Math.max(max_right, right_height);
                left++;
            }
            
            else
            {
                result += Math.max(Math.min(max_left, max_right) - right_height, 0);
                max_left = Math.max(max_left, left_height);
                max_right = Math.max(max_right, right_height);
                right--;
            }
            
            
        }
        
        return result;
    }
}