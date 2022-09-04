class Solution {
    Set<List<Integer>> results = new HashSet<>();
    
    public List<List<Integer>> subsets(int[] nums)
    {
        dfs(0, nums, new HashSet<>(), new ArrayList<>());
        return new ArrayList<>(results);
    }
    
    private void dfs(int start, int[] nums, HashSet<Integer> hashset, List<Integer> result)
    {
        if(!results.contains(result))
        {
            results.add(new ArrayList<>(result));
        }
        
        int N = nums.length;
        for(int i = start; i < N; ++i)
        {
            if(!hashset.contains(i))
            {
                hashset.add(i);
                result.add(nums[i]);
                
                dfs(i, nums, hashset, result);
                
                result.remove(result.size() - 1);
                hashset.remove(i);
            }
        }
    }
}