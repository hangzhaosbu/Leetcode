class Solution {
    //  S S S S O O O O L L L L L
    //          i t   j
    
    private int[] quickselect(int left, int right, int[][] count, int k)
    {
        if(left > right)
        {
            return null;
        }
        
        
        int mid = (right - left) / 2 + left;
        int pivot = count[mid][1];
        
        int i = left, t = left, j = right;
        
        while(t <= j)
        {
            if(count[t][1] < pivot)
            {
                int[] temp = count[t];
                count[t] = count[i];
                count[i] = temp;
                
                i++;
                t++;
            }
            
            else if(count[t][1] > pivot)
            {
                int[] temp = count[t];
                count[t] = count[j];
                count[j] = temp;
                
                j--;
            }
            
            else
            {
                t++;
            }
        }
        
        if(right - j + 1 == k)
        {
            int[] result = new int[k];
            int p = 0;
            
            for(int k1 = j; k1 <= right; ++k1)
            {
                result[p++] = count[k1][0];
            }
            return result;
        }
        
        else if(right - j + 1 > k)
        {
            return quickselect(j + 1, right, count, k);
        }
        
        else
        {
            int[] left_part = quickselect(left, j - 1, count, k - (right - j + 1));
            
            int[] result = new int[left_part.length + (right - j + 1)];
            int p = 0;
            
            for(int k1 = 0; k1 < left_part.length; ++k1)
            {
                result[p++] = left_part[k1];
            }
            
            for(int k1 = j; k1 <= right; ++k1)
            {
                result[p++] = count[k1][0];
            }
            
            return result;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int i = 0; i < nums.length; ++i)
        {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }
        
        int[][] count = new int[hashmap.size()][2];
        int p = 0;
        
        for(int key : hashmap.keySet())
        {
            count[p++] = new int[]{key, hashmap.get(key)};
        }
        
        // for(int key : hashmap.keySet())
        // {
        //     System.out.print(key + "," + hashmap.get(key) + "  ");
        // }
        
        return quickselect(0, hashmap.size() - 1, count, k);
    }
}