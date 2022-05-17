class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        
        if(triangle.size() == 1)
        {
            for(int i = 0; i < triangle.get(0).size(); i ++){
                result = Math.min(result, triangle.get(0).get(i));;
            }
            return result;
        }
        List<List<Integer>> dp = new ArrayList<>();
        
        for(List<Integer> t : triangle)
        {
            dp.add(new ArrayList<>(t));
        }
        
        for(int i = 1; i < dp.size(); i++)
        {
            for(int j = 0; j < dp.get(i).size(); j++)
            {
                dp.get(i).set(j, Math.min((j - 1 >= 0 ? dp.get(i - 1).get(j - 1) : Integer.MAX_VALUE), (j < dp.get(i - 1).size() ? dp.get(i - 1).get(j) : Integer.MAX_VALUE)) + triangle.get(i).get(j));
                
                if(i == dp.size() - 1)
                {
                    result = Math.min(result, dp.get(i).get(j));
                }
            }
        }
        
        
        // for(int i = 1; i < dp.size(); i++)
        // {
        //     for(int j = 0; j < dp.get(i).size(); j++)
        //     {
        //         System.out.print(dp.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
            
                
        
        return result;
    }
}