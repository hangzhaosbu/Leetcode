class Solution {
public:
    int maxSubArray(vector<int>& nums)
    {
        return divideConquer(0, nums.size() - 1, nums);
    }
    
    int divideConquer(int left, int right, vector<int>& nums)
    {
        if(left > right) return 0;
        if(left == right)
        {
            return nums[left];
        }
        
        int mid = (right - left) / 2 + left;
        
        
        int leftMax = divideConquer(left, mid, nums);
        int rightMax = divideConquer(mid + 1, right, nums);
        
        int l = mid;
        int totalLeft = 0;
        int maxTotalLeft = INT_MIN;
        
        while(l >= left)
        {
            totalLeft += nums[l--];
            maxTotalLeft= max(maxTotalLeft, totalLeft);
        }
        
        
        int r = mid + 1;
        int totalRight = 0;
        int maxTotalRight = INT_MIN;
        
        while(r <= right)
        {
            totalRight += nums[r++];
            maxTotalRight = max(maxTotalRight, totalRight);
        }
        
        // cout << left << "," << right << ", " << leftMax << " " << rightMax << " " << totalLeft + totalRight << endl;
        return max(leftMax, max(rightMax, maxTotalLeft + maxTotalRight));
    }
};