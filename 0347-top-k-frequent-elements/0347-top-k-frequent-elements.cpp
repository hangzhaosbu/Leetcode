class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k)
    {
        unordered_map<int,int> map;
        
        for(auto & num : nums)
        {
            if(map.find(num) == map.end())
            {
                map[num] = 1;
            }
            else
            {
                map[num]++;
            }
        }
        
        vector<vector<int>> candidates;
        
        for(auto& [key, val] : map)
        {
            candidates.push_back({val, key});
        }
        
        return quickselect(0, candidates.size() - 1, k, candidates);
    }
    
    vector<int> quickselect(int left, int right, int k, vector<vector<int>> & candidates)
    {
        
        // S S S S S O O O L L L L 
        //           i t j
        
        if(left == right)
        {
            return {candidates[left][1]};
        }
        
        int mid = (right - left) / 2 + left;
        
        int pivot = candidates[mid][0];
        
        int i = left, j = right, t = left;
        
        while(t <= j)
        {
            if(candidates[t][0] < pivot)
            {
                vector<int> temp = candidates[t];
                candidates[t] = candidates[i];
                candidates[i] = temp;
                i++;
                t++;
            }
            else if(candidates[t][0] > pivot)
            {
                vector<int> temp = candidates[t];
                candidates[t] = candidates[j];
                candidates[j] = temp;
                j--;
            }
            else
            {
                t++;
            }
        }
        
        vector<int> ans;
        
        if(right - i + 1 == k)
        {
            for(int p = i; p <= right; p++)
            {
                ans.push_back(candidates[p][1]);
            }
            
            return ans;
        }
        else if(right - i + 1 < k)
        {
            for(int p = i; p <= right; p++)
            {
                ans.push_back(candidates[p][1]);
            }
            
            vector<int> rights = quickselect(left, i - 1, k - (right - i + 1), candidates);
            
            for(auto & num : rights)
            {
                ans.push_back(num);
            }
            
            return ans;
        }
        else
        {
            return quickselect(i + 1, right, k, candidates);
        }
    }
};