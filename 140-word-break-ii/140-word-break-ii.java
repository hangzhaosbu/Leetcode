class Solution {
    
    private List<String> dfs(int index, String s, HashSet<String> hashset, HashMap<String, List<String>> hashmap)
    {
        int N = s.length();
        
        if(hashmap.containsKey(s.substring(index)))
        {
            return hashmap.get(s.substring(index));
        }
        
        List<String> result = new ArrayList<String>();
        
        if(index == N)
        {
            result.add("");
            return result;
        }
        
        for(int i = index; i < N + 1; ++i)
        {
            if(hashset.contains(s.substring(index, i)))
            {
                List<String> future = dfs(i, s, hashset, hashmap);
                for(String c : future)
                {
                    if(c.length() > 0)
                    {
                        result.add(s.substring(index, i) + " " + c);
                    }
                    else
                    {
                        result.add(s.substring(index, i));
                    }
                }
            }
        }
        
        hashmap.put(s.substring(index), result);
        return result;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        
        return dfs(0, s, new HashSet<>(wordDict), new HashMap<>());
    }
}