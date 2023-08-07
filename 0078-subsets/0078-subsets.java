class Solution {
    
    List<List<Integer>> result;
    int k;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        for(k = 0; k <= nums.length; k++)
        {
            dfs(0, new ArrayList<Integer>(), nums);
        }
        
        return result;
    }
    
    
    private void dfs(int start, List<Integer> curt, int[] nums)
    {
        if(curt.size() == k)
        {
            result.add(new ArrayList<Integer>(curt));
            return;
        }
        
        for(int i = start; i < nums.length; i++)
        {
            curt.add(nums[i]);
            dfs(i + 1, curt, nums);
            curt.remove(curt.size() - 1);
        }
        
    }
}