class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = new ArrayList<>();
        prev.add(triangle.get(0).get(0));
        
        for(int i = 1; i < triangle.size(); i++)
        {
            
            List<Integer> curt = new ArrayList<>();
            
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                curt.add(Math.min((j - 1 >= 0 ? prev.get(j - 1) : Integer.MAX_VALUE), (j < prev.size() ? prev.get(j) : Integer.MAX_VALUE)) + triangle.get(i).get(j));
                
            }
            
            prev = curt;
        }
        
        return Collections.min(prev);
    }
}