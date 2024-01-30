class Solution:
    def twoSum(self, A: List[int], target: int) -> List[int]:
        l, r = 0, len(A) - 1
        
        while l < r:
            if A[l] + A[r] > target:
                r -= 1
            elif A[l] + A[r] < target:
                l += 1
            else:
                return [l + 1, r + 1]