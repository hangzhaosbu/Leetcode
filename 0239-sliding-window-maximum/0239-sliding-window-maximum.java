class Solution {
    private int[] arr = new int[99999];
    private int pointer = 0;
    private int first = 0;

    private void offer(int x) {
        arr[pointer] = x;
        pointer++;
    }

    private int poll() {
        int x = arr[first];
        first++;
        return x;
    }

    private int peek() {
        return arr[first];
    }

    private boolean empty() {
        return pointer == first;
    }

    private int size() {
        return pointer - first;
    }

   
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length <= 0 || k <= 0) {
            return new int[0];
        }



        int[] ans = new int[nums.length - k + 1];

        int index = 0;
        for (int start = 0; start < nums.length; start++) {
            while (!empty() && peek() < start - k + 1) {
                poll();
            }
           
       
            while (!empty() && nums[start] >= nums[arr[pointer-1]]) {
                pointer--;
            }


            offer(start);
           
           
            if (start >= k-1){
                ans[index] = nums[peek()];
                index++;
            }

        }

        return ans;
    }  
}