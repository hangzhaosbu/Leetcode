class Solution {
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> hashset = new HashSet<>();
        
        for(int num : nums)
        {
            if(hashset.contains(num))
            {
                return true;
            }
            
            hashset.add(num);
        }
        
        return false;
    }
}