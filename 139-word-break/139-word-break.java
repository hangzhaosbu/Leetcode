class Solution {
    
    HashMap<String, Boolean> dp;
    
    private boolean dfs(int start, String s, HashSet<String> hashset)
    {
        int N = s.length();
        if(dp.containsKey(s.substring(start, N)))
        {
            return dp.get(s.substring(start, N));
        }
        
        if(s.substring(start, N) == "" || hashset.contains(s.substring(start, N)))
        {
            dp.put(s.substring(start, N), true);
            return true;
        }
        
        for(int i = start; i < N + 1; ++i)
        {
            String curt = s.substring(start, i);
            if(hashset.contains(curt) && dfs(i, s, hashset))
            {
                dp.put(s.substring(start, N), true);
                return true;
            }
        }
        
        dp.put(s.substring(start, N), false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict)
    {
        int N = s.length();
        dp = new HashMap<>();
        return dfs(0, s, new HashSet<>(wordDict));
    }
}