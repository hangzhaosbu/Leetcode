class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) 
    {
        return quickselect(0, nums.size() - 1, nums, k);
    }
    
    int quickselect(int left, int right, vector<int>& nums, int k)
    {
        // S S S S S O O O L L L L
        if(left == right) return nums[left];
        int r = left + rand() % (right - left);
        int pivot = nums[r];
        int i = left, t = left, j = right;
        int equals = 0;
        
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
                equals++;
            }
        }
        
        if(right - j + 1 == k) return nums[j];
        else if(right - j + 1 > k)
        {
            return quickselect(j + 1, right, nums, k);
        }
        else
        {
            if(equals >= 99990) return nums[i];
            return quickselect(left, j - 1, nums, k - (right - j + 1));
        }
    }
};