class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        res = []
        
        for i in range(len(nums)):
            for j in range(len(nums[i])):
                if i + j >= len(res):
                    res.append([])
                res[i + j].append(nums[i][j])
        
        return [y for x in res for y in x[::-1]]