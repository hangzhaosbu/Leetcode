class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0;
        
        for(int i = 0; i < 32; i++)
        {
            if((n >> i) & 1 == 1)
            {
                ans = ans*2 + 1;
            }
            else
            {
                ans = ans*2;
            }
        }
        
        return ans;
    }
};