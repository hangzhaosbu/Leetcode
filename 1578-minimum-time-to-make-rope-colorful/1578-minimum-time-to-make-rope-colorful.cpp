class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int i = 0, N = colors.length();
        int ans = 0;
        
        while(i < N)
        {
            int minCost = -1;
            int j = i, total = 0;
            
            while(j < N && colors[j] == colors[i])
            {
                total += neededTime[j];
                minCost = max(minCost, neededTime[j]);
                j++;
            }
            
            if(j != i + 1)
                ans += total - minCost;
            i = j;
        }
        
        return ans;
    }
};