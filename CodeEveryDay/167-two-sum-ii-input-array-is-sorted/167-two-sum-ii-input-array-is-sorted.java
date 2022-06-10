class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0) return numbers;
        
        int[] arr = new int[2];
        int i = 0, j = numbers.length -1;
        
        while(i <= j){
            if(numbers[i] + numbers[j] < target){
                i++;
            }
            else if(numbers[i] + numbers[j] == target){
                arr[0] = i+1;
                arr[1] = j+1;
                break;
            }
            else if(numbers[i] + numbers[j] > target){
                j--;
            }
        }
        
        return arr;
    }
}