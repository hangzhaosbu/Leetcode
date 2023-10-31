class Solution {
public:
    bool makesquare(vector<int>& A)
    {
        sort(A.begin(), A.end(), greater<int>());
        vector<int> matchsticks(4, 0);
        int total = 0;
        
        for(auto num : A) total += num;
        
        if(total % 4 != 0) return false;
        
        return dfs(0, total / 4, A, matchsticks);
    }
    
    bool dfs(int start, int goal, vector<int>& A, vector<int>& matchsticks)
    {
        if(start == A.size())
        {
            return matchsticks[0] == matchsticks[1] && matchsticks[1] == matchsticks[2] && matchsticks[2] == matchsticks[3];
        }
        
        for(int i = 0; i < 4; i++)
        {
            if(matchsticks[i] + A[start] > goal) continue;
            if(i > 0 && matchsticks[i] == matchsticks[i - 1]) continue;
            
            matchsticks[i] += A[start];
            if(dfs(start + 1, goal, A, matchsticks)) return true;;
            matchsticks[i] -= A[start];
        }
        
        return false;
    }
};