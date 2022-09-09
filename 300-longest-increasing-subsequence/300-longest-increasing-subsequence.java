class Solution {
    public int lengthOfLIS(int[] nums) {
        //[2,3,7,18]
        
        List<Integer> LIS = new ArrayList<>();
        
        for(int i = 0; i < nums.length; ++i)
        {
            int curt = nums[i];
            
            int index = Collections.binarySearch(LIS, curt);
            if(index < 0)
            {
                index = - (index + 1);
            }
            
            // System.out.println(index);
            if(index == LIS.size())
            {
                LIS.add(curt);
            }
            else if(index < LIS.size())
            {
                if(LIS.get(index) > curt)
                {
                    LIS.set(index, curt);
                }
            }
        }
        
        return LIS.size();
    }
}