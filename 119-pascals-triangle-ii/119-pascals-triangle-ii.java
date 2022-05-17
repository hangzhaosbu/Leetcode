class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        while(rowIndex-- > 0)
        {
            List<Integer> curt = new ArrayList<>();
            
            for(int i = -1; i < prev.size(); i++)
            {
                curt.add(((i >= 0) ? prev.get(i) : 0) + ((i + 1 < prev.size()) ? prev.get(i + 1) : 0));
            }
            prev = curt;
        }
        
        return prev;
    }
}