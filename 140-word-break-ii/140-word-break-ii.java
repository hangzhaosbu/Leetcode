class Solution {
    List<String> result = new ArrayList<String>();
    
    private void dfs(int index, String s, StringBuilder curt, HashSet<String> hashset)
    {
        int N = s.length();
        if(index == N)
        {
            result.add(curt.toString().substring(1));
            return;
        }
        
        for(int i = index; i < N + 1; ++i)
        {
            if(hashset.contains(s.substring(index, i)))
            {
                
                StringBuilder temp = new StringBuilder(curt);
                curt.append(" " + s.substring(index, i));
                
                dfs(i, s, curt, hashset);
                curt = temp;
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> hashset = new HashSet<>(wordDict);
        dfs(0, s, new StringBuilder(), hashset);
        return result;
    }
}