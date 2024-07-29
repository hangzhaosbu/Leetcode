class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        
        def recur(start, cur_sum, result, results):
            if cur_sum >= target:
                
                if cur_sum == target:
                    results.append(result[:])
                
                return
            
            
            for i in range(start, len(candidates)):
                cur_sum += candidates[i]
                result.append(candidates[i])
                
                recur(i, cur_sum, result, results)
                cur_sum -= candidates[i]
                result.pop()
        
        result = []
        results = []
        
        recur(0, 0, result, results)
        return results
            