class Solution {
    public boolean isHappy(int n) {
        
        int sum = 0;
        HashSet<Integer> hashset = new HashSet<>();
        
        while(true)
        {
            if(!hashset.contains(n))
            {
                hashset.add(n);
            }
            else
            {
                break;
            }
            
            while(n > 0)
            {
                sum += (n%10) * (n%10);
                n/=10;
            }
            
            n = sum;
            sum = 0;
            
            if(n == 1) return true;
        }
        
        return false;
    }
}