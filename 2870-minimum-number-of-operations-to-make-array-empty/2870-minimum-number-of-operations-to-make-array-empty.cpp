class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int,int> map;
        int ans = 0;
        
        for(auto& num : nums)
        {
            map[num]++;
        }
        
        for(auto& [key, value] : map)
        {
            if(value == 1)
            {
                return -1;
            }
            else if(value % 3 == 0)
            {
                ans += value / 3;
            }
            
            else if(value % 2 == 0)
            {
                int count = value / 3;
                count--;
                
                count += 2;
                
                ans += count;
            }
            else
            {
                int count = value / 3;
                count--;
                
                count += 2;
                
                ans += count;
            }
        }
        
        return ans;
    }
};