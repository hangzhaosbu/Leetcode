class Solution {
    
    private boolean valid(int[] hashmap, int j, int k, String s)
    {
        hashmap[s.charAt(j) - 'A']++;
        int max_val = 0, sum = 0;
        
        for(int num : hashmap)
        {
            max_val = Math.max(max_val, num);
            sum += num;
        }
        
        if(sum - max_val <= k)
        {
            return true;
        }
        else
        {
            hashmap[s.charAt(j) - 'A']--;
            return false;
        }
    }
    
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] hashmap = new int[26];
        int result = 0;
        
        int j = 0;
        for(int i = 0; i < N; ++i)
        {
            while(j < N && valid(hashmap, j, k, s))
            {
                j++;
                
            }
            
            result = Math.max(result, j - i);
            hashmap[s.charAt(i) - 'A']--;
        }
        
        return result;
    }
}