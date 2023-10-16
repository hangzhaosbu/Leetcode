class Solution {
    public int searchInsert(int[] arr, int target) {
        int L = 0;
        int R = arr.length-1;
        while(L < R) {
            int mid = (L + R) / 2;
            if(arr[mid] < target && arr[mid+1] > target) return mid + 1;
            else if(arr[mid] < target) L = mid + 1;
          	else R = mid;
        }
        
        if(arr[R] < target) return R + 1;
        return R;
    }
}