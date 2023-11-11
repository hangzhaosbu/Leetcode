class Solution:
    def backtracking(self, nums, result, results, used):
        #base case
        if len(result) == len(nums):
            results.append(result[:])
            return
        
        #recursive case
        for i in range(len(nums)):
            num = nums[i]
            
            if used[i]:
                continue
            
            result.append(num)
            used[i] = True
            self.backtracking(nums, result, results, used)
            result.pop()
            used[i] = False
        
    
    
    def permute(self, nums: List[int]) -> List[List[int]]:
        results = [] #store all the orders
        result = [] #store the current order we are building
        used = [False for _ in range(len(nums))] #store which number has been used
        
        self.backtracking(nums, result, results, used)
        
        return results