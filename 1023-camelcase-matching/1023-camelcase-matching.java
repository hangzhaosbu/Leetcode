class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) 
    {
        List<Boolean> result = new ArrayList<>();
        int size1 = pattern.length();
        
        for(String query : queries)
        {
            int p1 = 0, p2 = 0;
            int size2 = query.length();
            
            boolean curr = true;
            
            while(p1 < size1 && p2 < size2)
            {
                if(pattern.charAt(p1) == query.charAt(p2))
                {
                    p1++;
                    p2++;
                }
                else
                {
                    if(query.charAt(p2) >= 97 && query.charAt(p2) <= 122)
                    {
                        p2++;
                    }
                    else
                    {
                        curr = false;
                        break;
                    }
                }
            }
            
            if(p1 < size1)
            {
                curr = false;
            }
            
            while(p2 < size2)
            {
                if(query.charAt(p2) >= 65 && query.charAt(p2) <= 90)
                {
                    curr = false;
                    break;
                }
                p2++;
            }
            
            result.add(curr);
        }
        
        return result;
    }
}