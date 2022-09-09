class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                {
                    return b[1] - a[1];
                }
                else
                {
                    return a[0] - b[0];
                }
            }
        });
        
        int N = envelopes.length;
        int[] A = new int[N];
        for(int i = 0; i < N; ++i)
        {
            A[i] = envelopes[i][1];
        }
        
        
        // find LIS in A
        return lengthOfLIS(A);
    }
    
    
    private int lengthOfLIS(int[] nums) {
        //[2,3,7,18]
        
        List<Integer> LIS = new ArrayList<>();
        
        for(int i = 0; i < nums.length; ++i)
        {
            int curt = nums[i];
            
            int index = Collections.binarySearch(LIS, curt);
            if(index < 0)
            {
                index = - (index + 1);
            }
            
            if(index == LIS.size())
            {
                LIS.add(curt);
            }
            else if(index < LIS.size())
            {
                if(LIS.get(index) > curt)
                {
                    LIS.set(index, curt);
                }
            }
        }
        
        return LIS.size();
    }
}