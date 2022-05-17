class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        
        while(numRows-- > 0)
        {
            List<Integer> curt = new ArrayList<>();
            result.add(prev);
            
            for(int i = -1; i < prev.size(); i++)
            {
                curt.add(((i >= 0) ? prev.get(i) : 0) + ((i + 1 < prev.size())? prev.get(i + 1) : 0));
            }
            
            prev = curt;
        }
        
        return result;
    }
}