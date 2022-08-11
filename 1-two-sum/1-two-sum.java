class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int i = 0; i < nums.length; ++i)
        {
            if(hashmap.containsKey(nums[i]))
            {
                return new int[]{hashmap.get(nums[i]), i};
            }
            
            hashmap.put(target - nums[i], i);
        }
        return new int[]{};
    }
}