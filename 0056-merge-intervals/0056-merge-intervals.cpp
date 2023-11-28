class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
            return a[0] < b[0];
        });
        
        vector<vector<int>> ans;
        stack<vector<int>> stck;
        
        for(int i = 0; i < intervals.size(); i++)
        {
            if(stck.empty())
            {
                stck.push(intervals[i]);
            }
            else
            {
                vector<int> curt = stck.top();
                if(intervals[i][0] <= curt[1])
                {
                    stck.pop();
                    int start = min(intervals[i][0], curt[0]);
                    int end = max(intervals[i][1], curt[1]);
                    
                    stck.push({start, end});
                }
                else
                {
                    stck.push(intervals[i]);    
                }
            }
        }
        
        while(!stck.empty())
        {
            ans.push_back(stck.top());
            stck.pop();
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};