class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n == 0) return;
        
        if(m == 0){
            
            for(int i = 0; i< n; i++){
                
                nums1[i] = nums2[i];
            }
        }
                
        int count1 = 0, count2= 0, count3= 0;
        
        int[] arr = new int[m+n];
        
        while(count1 != (m+n)){
            
            if(count3 < n && (count2 == m || nums1[count2] >= nums2[count3])){
                
                arr[count1++] = nums2[count3++];
            }
            else if(count2 < m && (count3 == n || nums1[count2] < nums2[count3])){
                
                arr[count1++] = nums1[count2++];
            }
        
        }
        
        for(int i = 0; i< arr.length; i++){
            
            nums1[i] = arr[i];
        }
        
    }
}