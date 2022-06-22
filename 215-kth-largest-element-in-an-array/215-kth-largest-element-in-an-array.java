class Solution {
    
    private int quickselect(int left, int right, int[] nums, int k)
    {
        int pivot = nums[(left + right) / 2];
        int i = left, t = left, j = right;
        
        while(t <= j)
        {
            if(nums[t] < pivot)
            {
                int temp = nums[t];
                nums[t] = nums[i];
                nums[i] = temp;
                i++;
                t++;
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
        
        if(right - j >= k)
        {
            return quickselect(j + 1, right, nums, k);
        }
        else if(right - i + 1 >= k)
        {
            return pivot;
        }
        else
        {
            return quickselect(left, i - 1, nums, k - (right - i + 1));
        }
    }
    
    public int findKthLargest(int[] nums, int k)
    {
        /*
           S S S S S O O O L L L
           l         i   j     r
        */
        return quickselect(0, nums.length - 1, nums, k);
    }
}