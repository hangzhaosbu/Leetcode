class Solution:

    def __init__(self, nums: List[int]):
        self.hashmap = {}
        
        for i, num in enumerate(nums):
            if num not in self.hashmap:
                self.hashmap[num] = []
            self.hashmap[num].append(i)

    def pick(self, target: int) -> int:
        l = self.hashmap[target]
        r = int(random.random() * len(l))
        return l[r]


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)