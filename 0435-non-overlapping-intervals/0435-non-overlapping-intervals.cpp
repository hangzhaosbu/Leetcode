class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] < b[1];
        });
        
        stack<vector<int>> stck;
        int count = 0;
        
        for(int i = 0; i < intervals.size(); i++)
        {
            if(stck.empty())
            {
                stck.push(intervals[i]);
            }
            else
            {
                vector<int> curt = stck.top();
                
                if(intervals[i][0] < curt[1])
                {
                    count++;
                }
                else
                {
                    stck.push(intervals[i]);
                }
            }
        }
        
        return count;
    }
};