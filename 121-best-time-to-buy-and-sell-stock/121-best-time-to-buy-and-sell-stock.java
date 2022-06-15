class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        
        for(int price : prices)
        {
            result = Math.max(price - min, result);
            min = Math.min(min, price);
        }
        
        return result;
    }
}