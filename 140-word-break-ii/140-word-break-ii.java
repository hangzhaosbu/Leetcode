class Solution {
    
    private List<String> dfs(String s, HashSet<String> hashset, HashMap<String, List<String>> hashmap)
    {
        int N = s.length();
        
        if(hashmap.containsKey(s))
        {
            return hashmap.get(s);
        }
        
        List<String> result = new ArrayList<String>();
        
        if(N == 0)
        {
            result.add("");
            return result;
        }
        
        for(int i = 1; i < N + 1; ++i)
        {
            if(hashset.contains(s.substring(0, i)))
            {
                List<String> future = dfs(s.substring(i), hashset, hashmap);
                for(String c : future)
                {
                    if(c.length() > 0)
                    {
                        result.add(s.substring(0, i) + " " + c);
                    }
                    else
                    {
                        result.add(s.substring(0, i));
                    }
                }
            }
        }
        
        hashmap.put(s, result);
        return result;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }
}