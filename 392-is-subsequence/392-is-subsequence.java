class Solution {
    public boolean isSubsequence(String s, String t) {
        HashMap<Character, List<Integer>> position = new HashMap<>();
        
        for(int i = 0; i < t.length(); ++i)
        {
            char c = t.charAt(i);
            
            if(position.containsKey(c))
            {
                position.get(c).add(i);
            }
            else
            {
                List<Integer> curt = new ArrayList<>();
                curt.add(i);
                position.put(c, curt);
            }
        }
        
        
        int index = -1;
        
        for(int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            
            if(!position.containsKey(c))
            {
                return false;
            }
            
            boolean flag = false;
            
            for(int j = 0; j < position.get(c).size(); ++j)
            {
                if(index < position.get(c).get(j))
                {
                    index = position.get(c).get(j);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) return false;
        }
        
        return true;
    }
}