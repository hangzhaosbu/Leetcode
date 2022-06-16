class Solution {
    
    private boolean valid(int[] hashmap, int j, int k, String s)
    {
        int max_val = 0, flag = 0;
        int count = 0;
        
        for(int num : hashmap)
        {
            max_val = Math.max(max_val, num);
        }
        
        for(int num : hashmap)
        {
            if(num == max_val && flag == 0)
            {
                flag = 1;
            }
            else
            {
                count += num;
            }
        }
        
        return count <= k;
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
                hashmap[s.charAt(j++) - 'A']++;
            }
            
            if(valid(hashmap, j, k, s))
                result = Math.max(result, j - i);
            else
            {
                result = Math.max(result, j - i - 1);
            }
            hashmap[s.charAt(i) - 'A']--;
        }
        
        return result;
    }
}