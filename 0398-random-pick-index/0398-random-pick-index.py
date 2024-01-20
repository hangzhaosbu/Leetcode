class Solution:

    def __init__(self, nums: List[int]):
        self.hashmap = {}
        
        for i, num in enumerate(nums):
            if num not in self.hashmap:
                self.hashmap[num] = []
            
            self.hashmap[num].append(i)
            
        

    def pick(self, target: int) -> int:
        length = len(self.hashmap[target])
        r = random.randint(0, length - 1)
        
        return self.hashmap[target][r]


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)