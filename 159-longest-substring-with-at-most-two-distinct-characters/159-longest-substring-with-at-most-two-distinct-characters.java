class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        int i = 0, j = 0, N = s.length(), result = 0;
        
        while(i < N)
        {
            while(j < N && (hashmap.size() < 2 || hashmap.containsKey(s.charAt(j))))
            {
                hashmap.put(s.charAt(j), hashmap.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            
            result = Math.max(result, j - i);
            
            hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) - 1);
            if(hashmap.get(s.charAt(i)) == 0)
            {
                hashmap.remove(s.charAt(i));
            }
            i++;
        }
        
        return result;
    }
}