class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        int[] cha = new int[256];
        int N = s.length(), j = -1, result = 0;
        
        for(int i = 0; i < N; ++i)
        {
            while(j + 1 < N && cha[s.charAt(j + 1)] == 0)
            {
                cha[s.charAt(j + 1)]++;
                j++;
            }
            
            result = Math.max(result, j - i + 1);
            cha[s.charAt(i)]--;
        }
        
        return result;
    }
}