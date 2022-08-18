class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        
        Arrays.sort(boxTypes, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                return b[1] - a[1];
            }
        });
        
        
        for(int i = 0; i < boxTypes.length; ++i)
        {
            if(truckSize >= boxTypes[i][0])
            {
                truckSize -= boxTypes[i][0];
                result += boxTypes[i][0] * boxTypes[i][1];
            }
            else
            {
                result += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        
        return result;
    }
}