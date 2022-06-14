class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hashset = new HashSet<>();
        
        if(nums.length < 3)
        {
            return new ArrayList<>(hashset);
        }
        Arrays.sort(nums);
        int N = nums.length;
        int i = 0;
        
        while(i < N && nums[i] <= 0)
        {
            if(i > 0 && nums[i] == nums[i - 1])
            {
                i++;    
            }
            
            if(i < N && nums[i] <= 0)
            {
                int target = 0 - nums[i];
                int left = i + 1, right = N - 1;
                while(left < right)
                {
                    List<Integer> curt = new ArrayList<>();

                    if(nums[left] + nums[right] > target)
                    {
                        right--;
                    }
                    else if(nums[left] + nums[right] < target)
                    {
                        left++;
                    }
                    else
                    {
                        curt.add(nums[i]);
                        curt.add(nums[left]);
                        curt.add(nums[right]);
                        if(!hashset.contains(curt))
                        {
                            hashset.add(curt);
                        }
                            
                        left++;
                        right--;
                    }
                    
                    if(left >= right)
                    {
                        break;
                    }
                }
            }
            
            i++;
        }
        
        return new ArrayList<>(hashset);
    }
}