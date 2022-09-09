class Solution {
    public int numberOfWeakCharacters(int[][] properties)
    {
        //[[1,5],[10,4],[4,3]]
        //[[1,5],[4,5],[4,3],[10,10],[10,4]]
        Arrays.sort(properties, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                {
                    return b[1] - a[1];
                }
                else
                {
                    return a[0] - b[0];
                }
            }
        });
        
        int max_size = 0, count = 0;
        
        for(int i = properties.length - 1; i >= 0; --i)
        {
            if(properties[i][1] < max_size)
            {
                count++;
            }
            
            max_size = Math.max(max_size, properties[i][1]);
        }
        
        return count;
    }
}