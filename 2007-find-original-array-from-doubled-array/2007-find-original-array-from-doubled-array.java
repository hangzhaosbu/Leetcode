class Solution {
    public int[] findOriginalArray(int[] nums) {
        int N = nums.length;
        if(N % 2 == 1)
        {
            return new int[]{};
        }
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int num : nums)
        {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= 0; --i)
        {
            //,,,,2,1
            if(!hashmap.containsKey(nums[i])){
                continue;
            }
               
            if(!hashmap.containsKey(nums[i]/2))
            {
                return new int[]{};
            }
            
            if(nums[i]/2 == nums[i] && hashmap.get(nums[i]) == 1)
            {
                return new int[]{};
            }
            
            if(hashmap.get(nums[i]) > 0 && nums[i]%2 ==1)
            {
                return new int[]{};
            }
            
            hashmap.put(nums[i], hashmap.get(nums[i]) - 1);
            hashmap.put(nums[i]/2, hashmap.get(nums[i]/2) - 1);
            result.add(nums[i]/2);
            
            if(hashmap.containsKey(nums[i]) && hashmap.get(nums[i]) == 0)
            {
                hashmap.remove(nums[i]);
            }
            
            if(hashmap.containsKey(nums[i]/2) && hashmap.get(nums[i]/2) == 0)
            {
                hashmap.remove(nums[i]/2);
            }
        }
        
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); ++i)
        {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}