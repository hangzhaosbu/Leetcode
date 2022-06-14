class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        int i = 0;
        
        while(i < N && nums[i] <= 0)
        {
            if(i == 0 || nums[i] != nums[i - 1])
            {
                int left = i + 1, right = N - 1;
                while(left < right)
                {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum > 0)
                    {
                        right--;
                    }
                    else if(sum < 0)
                    {
                        left++;
                    }
                    else
                    {
                        result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                        while(left < right && nums[left] == nums[left - 1])
                        {
                            left++;
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }
}