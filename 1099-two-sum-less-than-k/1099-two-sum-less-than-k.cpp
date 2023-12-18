class Solution {
public:
    int twoSumLessThanK(const vector<int>& A, int K, int S = -1) {
      for (auto i = 0; i < A.size(); ++i)
        for (auto j = i + 1; j < A.size(); ++j)
          if (A[i] + A[j] < K) S = max(S, A[i] + A[j]);
      return S;
    }
};