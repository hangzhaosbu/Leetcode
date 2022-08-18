class Solution {
    public String breakPalindrome(String palindrome) {
        int N = palindrome.length();
        
        if(N == 1)
        {
            return "";
        }
        
        char[] chars = palindrome.toCharArray();
        
        for(int i = 0; i < N/2; ++i)
        {
            if(chars[i] != 'a')
            {
                chars[i] = 'a';
                
                return String.valueOf(chars);
            }
        }
        
        chars[N - 1] = 'b';
        return String.valueOf(chars);
    }
}