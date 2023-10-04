class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int N = nums.size();
        vector<vector<int>> results;
        
        for(int i = pow(2, N); i < pow(2, N + 1); i++)
        {
            string curt = bitset<11>(i).to_string().substr(11 - N);
            vector<int> result;
            
            for(int j = 0; j < curt.length(); j++)
            {
                if(curt[j] == '1')
                {
                    result.push_back(nums[j]);
                }
            }
            
            results.push_back(result);
        }
        return results;
    }
};