class Solution {
    public boolean isPalindrome(String s)
    {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        
        while(left <= right)
        {
            while(left <= right && !Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }
            
            
            while(left <= right && !Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }
            
            if(left > right)
            {
                break;
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