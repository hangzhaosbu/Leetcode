class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        auto begin = letters.begin(), end = letters.end();
        auto iter = upper_bound(begin, end, target);
        return iter != end ? *iter : *begin;
    }
};