class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = nums.length - 1; i >= 0; i--){
            int index = binarySearch(list, nums[i]);
            result[i] = index;
            list.add(index, nums[i]);
        }
        
        return Arrays.asList(result);
    }
    
    public int binarySearch(List<Integer> list, int target){
        if(list.size() == 0) return 0;
        if(list.get(0) >= target) return 0;
        if(list.get(list.size() - 1) < target) return list.size();
        
        int start = 0;
        int end = list.size() - 1;
        
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(list.get(mid) < target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        
        if(list.get(start) >= target){
            return start;
        }
        return end;
    }
}