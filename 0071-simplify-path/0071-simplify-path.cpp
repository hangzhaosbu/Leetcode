class Solution {
public:
    string simplifyPath(string path) 
    {
        int i = 0, j = 0, n = path.length();
        vector<string> tokens = split(path, '/');
        vector<string> ans;
        
        for(auto& token : tokens)
        {
            if(token == "" || token == ".")
            {
                continue;
            }
            else if(token == "..")
            {
                if(!ans.empty())
                    ans.pop_back();
            }
            else
            {
                ans.push_back(token);
            }
        }
        
        string res = "";
        
        res += "/";
        
        for(auto& str : ans)
        {
            res += str + "/";
        }
        
        if(ans.size() > 0)
            return res.substr(0, res.length() - 1);
        else
            return res;
    }
    
    
    vector<string> split(string path, char delim)
    {
        vector<string> ans;
        
        int i = 0, n = path.length();
        
        while(i < n && path[i] != delim)
        {
            i++;
        }
        
        ans.push_back(path.substr(0, i));
        
        while(i < n)
        {
            int j = i + 1;
            
            while(j < n && path[j] != delim)
            {
                j++;
            }
            
            ans.push_back(path.substr(i + 1,  j - i - 1));
            i = j;
        }
        
        return ans;
    }
};