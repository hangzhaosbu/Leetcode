class Solution {
    
    private int quickselect(int left, int right, int[] nums, int k)
    {
        int pivot = nums[(left + right) / 2];
        int i = left, t = left, j = right;
        int p = 0;
        
        while(t <= j)
        {
            if(nums[t] < pivot)
            {
                int temp = nums[i];
                nums[i] = nums[t];
                nums[t] = temp;
                i++;
                t++;
            }
            
            else if(nums[t] > pivot)
            {
                int temp = nums[j];
                nums[j] = nums[t];
                nums[t] = temp;
                j--;
            }
            
            else
            {
                t++;
            }
        }
        
        if(right - j >= k)
        {
            return quickselect(j + 1, right, nums, k);
        }
        
        else if(right - i + 1 >= k)
        {
            return pivot;
        }
        
        else
        {
            return quickselect(left, i - 1, nums, k - (right - i + 1));
        }
    }
    
    public int[] topKFrequent(int[] nums, int k)
    {
        /*
        S S S S S S S O O O L L L L
        l             i   j       r
        
        
        [1,1,1,2,2,3]
        2
        [1]
        1
        [4,1,-1,2,-1,2,3]
        2
        [1,2]
        2
        
        */
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        HashMap<Integer, List<Integer>> frequency = new HashMap<>();
        for(int num : nums)
        {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        
        int[] candidates = new int[hashmap.values().size()];
        int p = 0;
        
        for(Integer key : hashmap.keySet())
        {
            if(!frequency.containsKey(hashmap.get(key)))
            {
                frequency.put(hashmap.get(key), new ArrayList<Integer>());
            }
            frequency.get(hashmap.get(key)).add(key);
            candidates[p++] = hashmap.get(key);
        }
        
        int f = quickselect(0, candidates.length - 1, candidates, k);
        int[] result = new int[k];
        p = 0;
        
        for(int candidate : candidates)
        {
            if(candidate >= f)
            {
                for(int i = 0; i < frequency.get(candidate).size(); ++i)
                {
                    if(p < k)
                    {
                        result[p++] = frequency.get(candidate).get(i);
                        frequency.get(candidate).remove(frequency.get(candidate).get(i));
                    }
                }
            }
        }
        
        return result;
    }
}