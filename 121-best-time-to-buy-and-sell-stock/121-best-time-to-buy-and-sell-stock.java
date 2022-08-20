class Solution {
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int result = 0;
        
        for(int price : prices)
        {
            result = Math.max(result, price - min_val);
            min_val = Math.min(min_val, price);
        }
        return result;
    }
}