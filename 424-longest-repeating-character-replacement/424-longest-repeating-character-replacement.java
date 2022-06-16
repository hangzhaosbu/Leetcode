class Solution {
    
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] hashmap = new int[26];
        int result = 0;
        int j = 0, sum = 0;
        
        for(int i = 0; i < N; ++i)
        {
            while(j < N && sum - Arrays.stream(hashmap).max().getAsInt() <= k)
            {
                sum++;
                hashmap[s.charAt(j++) - 'A']++;
            }
            
            result = Math.max(result, (sum - Arrays.stream(hashmap).max().getAsInt() <= k) ? j - i : j - i - 1);
            hashmap[s.charAt(i) - 'A']--;
            sum--;
        }
        
        return result;
    }
}