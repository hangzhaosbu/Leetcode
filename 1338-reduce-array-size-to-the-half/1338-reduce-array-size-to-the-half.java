class Solution {
    public int minSetSize(int[] arr)
    {
        int[] count = new int[100001];
        int size = 0, result = 0;
        
        
        for(int i = 0; i < arr.length; ++i)
        {
            count[arr[i]]++;
            size++;
        }
        
        Arrays.sort(count);
        
        for(int i = 100000; i >= 0; --i)
        {
            size -= count[i];
            result ++;
            
            if(size <= arr.length/2)
            {
                break;
            }
        }
        
        return result;
    }
}