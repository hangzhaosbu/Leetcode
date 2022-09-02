class Solution {
    public List<List<Integer>> subsets(int[] nums)
    {
        int N = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        
        for(int i = (int) Math.pow(2, N); i < (int) Math.pow(2, N + 1); ++i)
        {
            String all = Integer.toBinaryString(i);
            String s = all.substring(1, all.length());
            
            List<Integer> result = new ArrayList<>();
            
            for(int j = 0; j < s.length(); ++j)
            {
                if(s.charAt(j) == '1'){
                    result.add(nums[j]);
                }
            }
            
            results.add(result);
        }
        
        return results;
    }
}