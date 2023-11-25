class Solution {
public:
    void sortColors(vector<int>& nums) {
        int i = 0, t = 0, j = nums.size() - 1;
        
        while(t <= j)
        {
            if(nums[t] < 1)
            {
                int temp = nums[t];
                nums[t] = nums[i];
                nums[i] = temp;
                i++;
                t++;
            }
            else if(nums[t] > 1)
            {
                int temp = nums[j];
                nums[j] = nums[t];
                nums[t] = temp;
                j--;
            }
            else{
                t++;
            }
        }
    }
};