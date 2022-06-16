class Solution {
    public int maxProfit(int[] prices) {
        
        /*
        hold    sold
        
        */
        int hold = Integer.MIN_VALUE/2, sold = 0;
        
        for(int price : prices)
        {
            int prev_hold = hold, prev_sold = sold;
            hold = Math.max(prev_hold, 0 - price);
            sold = Math.max(prev_sold, price + prev_hold);
        }
        
        return Math.max(sold, hold);
    }
}