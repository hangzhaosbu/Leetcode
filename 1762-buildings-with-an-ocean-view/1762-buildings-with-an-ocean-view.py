class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        res = []
        maxH = 0
        
        for i in range(len(heights) - 1, -1, -1):
            if heights[i] > maxH:
                res.append(i)
                
                maxH = heights[i]
        
        return res[::-1]