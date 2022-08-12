class Solution {
    
    private boolean valid(Character c)
    {
        return (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }
    
    public boolean isPalindrome(String s)
    {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        
        while(left <= right)
        {
            while(left < right && !valid(s.charAt(left)))
            {
                left++;
            }
            
            while(left < right && !valid(s.charAt(right)))
            {
                right--;
            }
            
            if(s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}