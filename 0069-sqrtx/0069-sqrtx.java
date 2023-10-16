class Solution {
    public int mySqrt(int x) {
        // binary search
        double l = 0, r = x;
        
        while(l < r)
        {
            double mid = (l + r) / 2;
            if(mid*mid < x) l = mid + 0.0000001;
            else if(mid*mid > x) r = mid - 0.0000001;
            else return (int) mid;
        }
        
        return (int) l;
    }
}