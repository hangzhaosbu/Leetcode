class Solution:
    def trap(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        maxL = 0
        maxR = 0
        ans = 0
        
        while l < r:
            maxL = max(maxL, height[l])
            maxR = max(maxR, height[r])
            
            if height[l] < height[r]:
                ans += maxL - height[l]
                l += 1
            else:
                ans += maxR - height[r]
                r -= 1
        
        return ans