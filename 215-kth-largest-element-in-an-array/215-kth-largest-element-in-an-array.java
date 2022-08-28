class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        return quickselect(0, nums.length - 1, nums, k);
    }
    
    private int quickselect(int left, int right, int[] nums, int k)
    {
        if(left == right)
        {
            return nums[left];
        }
        
        int mid = (right - left) / 2 + left;
        int pivot = nums[mid];
        
        int i = left, t = left, j = right;
        
        while(t <= j)
        {
            if(nums[t] < pivot)
            {
                int temp = nums[t];
                nums[t] = nums[i];
                nums[i] = temp;
                
                t++;
                i++;
            }
            else if(nums[t] > pivot)
            {
                int temp = nums[t];
                nums[t] = nums[j];
                nums[j] = temp;
                
                j--;
            }
            else
            {
                t++;
            }
        }
        
        // S S S S O O O L L L L L
        //         i t j
        
        if(right - j + 1 == k)
        {
            return nums[j];
        }
        else if(right - j + 1 > k)
        {
            return quickselect(j + 1, right, nums, k);
        }
        
        else
        {
            return quickselect(left, j - 1, nums, k - (right - j + 1));
        }
    }
}