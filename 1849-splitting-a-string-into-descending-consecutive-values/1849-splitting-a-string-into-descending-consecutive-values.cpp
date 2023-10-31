typedef unsigned long long ull;
long long MX = 999999999999;

class Solution {
public:
    bool splitString(string s)
    {
        vector<ull> result;
        
        return dfs(0, s, result);
    }
    
    bool valid(vector<ull>& result)
    {
        // for(int i = 0; i < result.size(); i++) cout << result[i] << " ";
        // cout << endl;
        
        
        for(int i = 1; i < result.size(); i++)
        {
            if(result[i] + 1 != result[i - 1]) return false;
        }
        
        return true;
    }
    
    bool dfs(int start, string s, vector<ull>& result)
    {
        
        if(start == s.length()){
            if(result.size() >= 2 && valid(result)) return true;
            else return false;
        }
        
        bool ans = false;
        
        for(int i = start; i < s.length(); i++)
        {
            string curt = s.substr(start, i - start + 1);
            int p;
            ull num;
            bool works = false;
            
            if(curt.size() == 1 && curt[0] == '0')
            {
                num = stoull(curt);
            }
            else
            {
                p = 0;
                

                while(p < curt.length() - 1 && curt[p] == '0') p++;
                curt = curt.substr(p, curt.size() - p);

                if(curt.size() == 0) continue;
                num = stoull(curt);
                if(num > MX) break;
            }

            if(result.size() == 0)
            {
                result.push_back(num);
                works = true;
            }
            else
            {
                if(result[result.size() - 1] - 1 != num) continue;
                else 
                {
                    result.push_back(num);
                    works = true;
                }
            }
            
            if(works){
                ans |= dfs(i + 1, s, result);
                if(ans) return true;
                result.pop_back();
            }
        }
        
        
        
        
        return ans;
    }
};