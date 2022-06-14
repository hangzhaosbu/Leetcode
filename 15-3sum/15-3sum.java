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
        
        while(i < N)
        {
            if(i > 0 && nums[i] == nums[i - 1])
            {
                i++;    
            }
            
            if(i < N)
            {
                int target = 0 - nums[i];
                int left = i + 1, right = N - 1;


                while(left < right)
                {
                    List<Integer> curt = new ArrayList<>();

                    if(left < right && nums[left] + nums[right] > target)
                    {
                        right--;
                    }
                    else if(left < right && nums[left] + nums[right] < target)
                    {
                        left++;
                    }
                    else if(left < right && nums[left] + nums[right] == target)
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
                }
            }
            
            i++;
        }
        
        return new ArrayList<>(hashset);
    }
}