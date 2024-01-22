class Solution:

    def __init__(self, w: List[int]):
        self.prefix = []
        total = 0
        for weight in w:
            total += weight
            self.prefix.append(total)
            
        # print((self.prefix))

    def pickIndex(self) -> int:
        r = random.random() * self.prefix[-1]
        
        for i, num in enumerate(self.prefix):
            if r <= num:
                return i


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()