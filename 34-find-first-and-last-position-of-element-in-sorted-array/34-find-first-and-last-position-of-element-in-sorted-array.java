class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int start = 0;
        int end = nums.length - 1;
        
        // find first
        while(start < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] < target){
                start = mid +1;
            }
            else{
                end = mid;
            }
        }
        
        if(nums[start] == target){
            result[0] = start;
        }
        else{
            result[0] = -1;
        }
        
        
        // find last
        
        end = nums.length - 1;
        while(start < end){
            int mid = (end - start) / 2 + start + 1;
            
            if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid;
            }
        }
        
        if(nums[end] == target){
            result[1] = end;
        }
        else{
            result[1] = -1;
        }
        
        return result;
    }
}