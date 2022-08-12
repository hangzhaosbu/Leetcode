class Solution {
    public int maxProfit(int[] prices)
    {
        int sold = 0, hold = Integer.MIN_VALUE;
        
        for(int price : prices)
        {
            int prev_hold = hold;
            int prev_sold = sold;
            
            hold = Math.max(prev_hold, 0 - price);
            sold = Math.max(prev_sold, prev_hold + price);
        }
        
        return Math.max(hold, sold);
    }
}