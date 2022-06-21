class Solution
{
    private List<List<Integer>> results;
    
    public void dfs(int[] candidates, int start, int running_sum, int target, List<Integer> result)
    {
        if(running_sum > target)
        {
            return;
        }
        
        if(running_sum == target)
        {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i = start; i < candidates.length; ++i)
        {
            result.add(candidates[i]);
            running_sum += candidates[i];
                
            dfs(candidates, i, running_sum, target, result);
            
            running_sum -= candidates[i];
            result.remove(result.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        results = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayList<>());
        return results;
    }
}