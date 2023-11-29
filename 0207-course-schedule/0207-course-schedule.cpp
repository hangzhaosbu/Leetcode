class Solution {
public:
    vector<int> adj[2001];
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        unordered_map<int,int> indegree;
        int count = 0;
        
        for(auto & prerequisite : prerequisites)
        {
            int x = prerequisite[0];
            int y = prerequisite[1];
            
            adj[x].push_back(y);
            adj[y].push_back(x);
            
            if(indegree.find(x) == indegree.end())
            {
                indegree[x] = 0;
            }
            
            if(indegree.find(y) == indegree.end())
            {
                indegree[y] = 0;
            }
            
            indegree[x]++;
        }
        
        
        
        queue<int> q;
        
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                q.push(i);
                count++;
            }
        }
        
        // for(auto& [k,v] : indegree)
        // {
        //     cout << k << " " << v << " "<< count << endl;
        // }
        
        
        while(!q.empty())
        {
            int node = q.front();
            q.pop();
            
            for(auto & neighbor : adj[node])
            {
                if(indegree[neighbor] > 0)
                {
                    indegree[neighbor]--;
                    
                    if(indegree[neighbor] == 0)
                    {
                        q.push(neighbor);
                        count++;
                    }
                }
                
                
            }
        }
        
        return count == numCourses;
    }
};