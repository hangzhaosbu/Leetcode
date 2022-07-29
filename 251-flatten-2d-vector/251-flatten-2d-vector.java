class Vector2D {
    
    int i = 0, j = 0;
    int[][] nums = null;
    
    public Vector2D(int[][] vec) {
        nums = vec;
    }
    
    public int next() {
        if(i < nums[j].length)
        {
            i++;
            return nums[j][i - 1];
        }
        else
        {
            i = 0;
            i++;
            j++;
            while(nums[j].length == 0)
            {
                j++;
            }
            return nums[j][i - 1];
        }
    }
    
    public boolean hasNext() {
        int new_i = i, new_j = j;
        
        
        if(new_j < nums.length && new_i < nums[new_j].length)
        {
            new_i++;
            return new_j < nums.length || (new_i - 1 < nums[new_j].length);
        }
        else
        {
            new_i = 0;
            new_i++;
            new_j++;
            while(new_j < nums.length && nums[new_j].length == 0)
            {
                new_j++;
            }
            return new_j < nums.length && nums[new_j].length > 0;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */