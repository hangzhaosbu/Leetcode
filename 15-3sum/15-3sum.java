class Solution {
    public List<List<Integer>> threeSum(int[] nums)
    {
        int N = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < N; ++i)
        {
            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            
            int left = i + 1, right = nums.length - 1;
            
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                
                
                if(sum == 0)
                {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    
                    while(left < right && nums[right] == nums[right + 1])
                    {
                        right--;
                    }
                }
                else if(sum < 0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        
        return result;
    }
}