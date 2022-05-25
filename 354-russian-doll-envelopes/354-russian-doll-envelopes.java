class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int N = envelopes.length;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])
                {
                    return Integer.compare(a[0], b[0]);
                }
                else
                {
                    return Integer.compare(b[1], a[1]);
                }
            }
        });
        int[] dp = new int[N];
        int[] nums = new int[N];
        
        for(int i = 0; i < N; ++i)
        {
            nums[i] = envelopes[i][1];
        }
        
        int l = 0;
        
        for(int i = 0; i < N; ++i)
        {
            int j = Arrays.binarySearch(dp, 0, l, nums[i]);
            
            if(j < 0)
            {
                j = -(j + 1);
            }
            
            dp[j] = nums[i];
            if(j == l)
            {
                l++;
            }
        }
        
        return l;
    }
}