class Solution {
    
    private boolean valid(int[] hashmap, int k)
    {
        int max_val = 0, sum = 0;
        
        for(int num : hashmap)
        {
            max_val = Math.max(max_val, num);
            sum += num;
        }
        
        return sum - max_val <= k;
    }
    
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] hashmap = new int[26];
        int result = 0;
        
        int j = 0;
        for(int i = 0; i < N; ++i)
        {
            while(j < N && valid(hashmap, k))
            {
                hashmap[s.charAt(j++) - 'A']++;
            }
            
            result = Math.max(result, valid(hashmap, k) ? j - i : j - i - 1);
            hashmap[s.charAt(i) - 'A']--;
        }
        
        return result;
    }
}