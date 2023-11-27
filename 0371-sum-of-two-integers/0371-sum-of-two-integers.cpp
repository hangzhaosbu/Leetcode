class Solution {
public:
    int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int sum = 0;
        
        while(b != 0)
        {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        
        return sum;
    }
};