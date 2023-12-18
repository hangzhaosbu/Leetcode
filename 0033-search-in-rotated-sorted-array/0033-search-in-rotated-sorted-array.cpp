class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        
        while(left < right)
        {
            int mid = (right - left) / 2 + left;
            if(nums[mid] > target)
            {
                if(nums[mid] < nums[right])
                {
                    right = mid - 1;
                }
                else
                {
                    if(target < nums[left])
                    {
                        left = mid + 1;
                    }
                    else if(target > nums[left])
                    {
                        right = mid - 1;
                    }
                    else
                    {
                        return left;
                    }
                }
            }
            else if(nums[mid] < target)
            {
                if(nums[mid] < nums[right])
                {
                    if(target > nums[right])
                    {
                        right = mid - 1;
                    }
                    else if(target < nums[right])
                    {
                        left = mid + 1;
                    }
                    else
                    {
                        return right;
                    }
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                return mid;
            }
            
        }
        
        if(nums[left] == target)
            return left;
        
        // cout << left << " " << right << endl;
        return -1;
    }
};