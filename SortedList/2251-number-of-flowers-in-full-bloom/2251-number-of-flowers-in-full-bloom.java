class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        /*
        [1, 0], [3, 0], [4, 0], [7, 1], [8, 1], [9, 0], [13, 1], [14, 1]
        */
        
        int N = flowers.length;
        int[][] candidates = new int[2 * N][2];
        
        for(int i = 0;i < N; i++)
        {
            candidates[2 * i][0] = flowers[i][0];
            candidates[2 * i][1] = 0;
            
            candidates[2 * i + 1][0] = flowers[i][1] + 1;
            candidates[2 * i + 1][1] = 1;
        }
        
        
        Arrays.sort(candidates, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0])
                {
                    return a[0] - b[0];
                }
                else
                {
                    return a[1] - b[1];
                }
            }
        });
        
        int count = 0;
        int[] nums = new int[2 * N];
        int[] result = new int[persons.length];
        int[] temp_candidates = new int[2 * N];
        
        for(int i = 0; i < candidates.length; ++i)
        {
            if(candidates[i][1] == 0)
            {
                count++;
            }
            else
            {
                count--;
            }
            
            nums[i] = count;
            
            temp_candidates[i] = candidates[i][0];
        }
        
        
        for(int i = 0; i < persons.length; ++i)
        {
            int person = persons[i];
            
            int j = Arrays.binarySearch(temp_candidates, 0, 2 * N, person);
            
            if(j < 0)
            {
                j = - (j + 1);
            }
            
            while(j + 1 < 2 * N && person == candidates[j][0] && candidates[j][0] == candidates[j + 1][0])
            {
                j++;
            }
            
            if(j >= 2 * N)
            {
                result[i] = 0;
            }
            
            else if(j == 0)
            {
                if(candidates[j][0] == person)
                {
                    result[i] = nums[j];
                }
                else
                {

                    result[i] = 0;
                }
            }
            
            else
            {
                if(candidates[j][0] == person)
                {
                    result[i] = nums[j];
                }
                else
                {

                    result[i] = nums[j - 1];
                }
            }
        }
        
        return result;
    }
}