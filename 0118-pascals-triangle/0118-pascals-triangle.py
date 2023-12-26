class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]
        
        while len(ans) < numRows:
            prev = ans[-1]
            curt = []
            
            curt.append(1)
            for i in range(1, len(prev)):
                total = prev[i - 1] + prev[i]
                curt.append(total)
            curt.append(1)
            
            ans.append(curt)
        
        return ans