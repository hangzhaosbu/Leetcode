class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        for(int num : nums)
        {
            hashset.add(num);
        }
        
        int result = 0;
        for(int num : hashset)
        {
            if(!hashset.contains(num - 1))
            {
                int count = 0;
                int x = num;
                while(hashset.contains(x))
                {
                    x++;
                    count++;
                }
                
                result = Math.max(result, count);
            }
        }
        
        return result;
    }
}