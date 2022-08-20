class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashset = new HashSet<>();
        
        int i = 0, j = 0, N = s.length(), result = 0;
        
        while(i < N)
        {
            while(j < N && !hashset.contains(s.charAt(j)))
            {
                hashset.add(s.charAt(j));
                j++;
            }
            
            result = Math.max(result, j - i);
            
            hashset.remove(s.charAt(i));
            i++;
        }
        
        return result;
    }
}