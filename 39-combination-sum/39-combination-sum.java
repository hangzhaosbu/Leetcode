class Solution {
    List<List<Integer>> results;
    
    private void dfs(int start, int[] candidates, int target, List<Integer> result)
    {
        if(target < 0)
        {
            return;
        }
        
        if(target == 0)
        {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i = start; i < candidates.length; ++i)
        {
            result.add(candidates[i]);
            target -= candidates[i];
            
            dfs(i, candidates, target, result);
            
            target += candidates[i];
            result.remove(result.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        results = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>());
        return results;
    }
}