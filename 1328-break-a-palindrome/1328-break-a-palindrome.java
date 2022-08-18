class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        
        int left = 0, right = palindrome.length() - 1;
        int index = -1;
        
        StringBuilder result = new StringBuilder();
        
        while(left <= right)
        {
            if(palindrome.charAt(left) == 'a')
            {
                left++;
                right--;
            }
            else
            {
                index = left;
                break;
            }
        }
        
        if(index != -1)
        {
            for(int i = 0; i < palindrome.length(); i++)
            {
                if(i != index){
                    result.append(palindrome.charAt(i));
                }
                else
                {
                    result.append('a');
                }
            }
            
            String candidate = result.toString();
            
            int l = 0, r = candidate.length() - 1;
            boolean par = true;
            
            while(l < r)
            {
                if(candidate.charAt(l) == candidate.charAt(r))
                {
                    l++;
                    r--;
                }
                
                else
                {
                    return candidate;
                }
            }
            
            result =  new StringBuilder();
            boolean flag = true;
            
            for(int i = palindrome.length() - 1; i >= 0; --i)
            {
                Character c = palindrome.charAt(i);
                if(c < 122 && flag == true)
                {
                    result.append((char)(c + 1));
                    flag = false;
                }
                else
                {
                    result.append(c);
                }
            }

            return result.reverse().toString();
        }
        else
        {
            return palindrome.substring(0, palindrome.length() - 1) + "b";
        }
        
    }
}