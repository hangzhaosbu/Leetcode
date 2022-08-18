class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k)
    {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int result = 0;
        
        for(int i = 0; i < arr.length; ++i)
        {
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
        }
        
        int[][] count = new int[hashmap.size()][2];
        int p = 0;
        
        for(int key : hashmap.keySet())
        {
            count[p++] = new int[]{key, hashmap.get(key)};
        }
        
        Arrays.sort(count, new Comparator<>(){
            public int compare(int[] a , int[] b)
            {
                return a[1] - b[1];
            }
        });
        
        for(int i = 0; i < count.length; ++i)
        {
            if(count[i][1] <= k)
            {
                k-=count[i][1];
                result++;
            }
            else
            {
                break;
            }
                
        }
        
        return hashmap.size() - result;
    }
}