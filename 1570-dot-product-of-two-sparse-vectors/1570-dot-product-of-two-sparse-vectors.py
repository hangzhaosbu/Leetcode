class SparseVector:

    def __init__(self, nums: List[int]):
        self.hashmap = {}
        for i in range(len(nums)):
            if nums[i] != 0:
                self.hashmap[i] = nums[i]

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        total = 0
        
        for key in self.hashmap:
            if key in vec.hashmap:
                total += self.hashmap[key] * vec.hashmap[key]
        
        return total

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)