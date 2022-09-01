class Solution {
    public int maxProfit(int[] prices) {
        int low = 10000;
        int result = 0;
        
        
        for(int price : prices)
        {
            result = Math.max(result, price - low);
            low = Math.min(low, price);
        }
        
        return result;
    }
}