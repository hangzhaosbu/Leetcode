class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_set<string> set;
        
        for(auto & email : emails)
        {
            string curt;
            int start = 0;
            
            for(auto& c : email)
            {
                if(c == '@') break;
                if(c == '+') break;
                if(c != '.') curt += c;
            }
            
            for(int i = 0; i < email.length(); i++)
            {
                if(email[i] == '@')
                {
                    start = i;
                    break;
                }
            }
            
            curt += email.substr(start, email.size() - start);
            // cout << curt << endl;
            set.insert(curt);
        }
        
        return set.size();
    }
};