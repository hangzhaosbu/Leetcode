class MovingAverage:

    def __init__(self, size: int):
        self.nums = [-10010 for _ in range(size)]
        self.p = 0
        self.size = size
        self.count = 0
        self.total = 0

    def next(self, val: int) -> float:
        
        if self.nums[self.p] == -10010:
            self.total += val
            self.nums[self.p] = val
            self.p = (self.p + 1) % self.size
            self.count += 1
        else:
            self.total -= self.nums[self.p]
            self.total += val
            self.nums[self.p] = val
            self.p = (self.p + 1) % self.size
        
        return self.total / self.count


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)