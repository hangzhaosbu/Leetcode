class Solution {
public:
    double myPow(double x, int n) {
        if(n == 1) return x;
        if(x == 1 || n == 0) return 1;
        
        long long temp = 0;
        if(n < 0)
        {
            x = 1/x;
            if(n != INT_MIN)
                temp = -n;
            else
                temp = 2147483648;
            
            
            double y = myPow(x, (int) (temp / 2));
            if(temp % 2 == 0)
            {
                return y * y;
            }
            else
            {
                return x * y * y;
            }
        }
        
        else
        {
            double y = myPow(x, n/2);
            if(n % 2 == 0)
            {
                return y * y;
            }
            else
            {
                return x * y * y;
            }
        }
    }
};