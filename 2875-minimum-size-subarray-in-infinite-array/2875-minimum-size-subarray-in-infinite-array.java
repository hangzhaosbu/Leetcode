class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int val = minSizeSubarrayHelper(i,sum,target);
            ans = Math.min(ans,val);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int minSizeSubarrayHelper(int i,long[] sum, long target){
        int n = sum.length;
        long remSum = sum[n-1] - sum[i-1];
        if(target > remSum){
            int subAns = minSizeSubarrayHelper(1,sum,target-remSum);
            if(subAns == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (n-i) + subAns;
        }
        int low = i, high = n-1;
        while(low <= high){
            
            int mid = (low + high)/2 + ((low+high) % 2) ; // use ciel value
            long find = sum[mid] - sum[i-1];
            if(find == target){
                return mid - (i-1);
            }
            if(find > target){
                high = mid - 1;
            }   else {
                low = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}