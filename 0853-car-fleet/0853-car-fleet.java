class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Stack<Integer> stack = new Stack<>();
        int[][] pairs = new int[N][2];
        
        for(int i = 0; i < N; i++)
        {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for(int i = N - 1; i > -1; i--)
        {
            if(!stack.isEmpty())
            {   
                if(((float) target -pairs[stack.peek()][0]) / pairs[stack.peek()][1] < ( (float) target - pairs[i][0]) / pairs[i][1])
                    stack.push(i);
            }
            else
            {   
                stack.push(i);
            }
        }
        
        return stack.size();
    }
}