class Solution {
    public boolean winnerOfGame(String colors)
    {
        int As = 0;
        int Bs = 0;
        
        int i = 0, N = colors.length();
        
        while(i < N)
        {
            int j = i + 1;
            
            while(j < N && colors.charAt(j) == colors.charAt(i))
            {
                j++;
            }
            
            if(colors.charAt(i) == 'A')
            {
                As+= Math.max(0, j - i - 2);
            }
            else
            {
                Bs+= Math.max(0, j - i - 2);
            }
            
            i = j;
        }
        
        // System.out.println(As + "," + Bs);
        
        if(As > Bs) return true;
        else return false;
    }
}