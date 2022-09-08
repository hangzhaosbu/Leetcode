from sortedcontainers import SortedList
class HitCounter:

    def __init__(self):
        self.sortedlist = SortedList()

    def hit(self, timestamp: int) -> None:
        self.sortedlist.add(timestamp)

    def getHits(self, timestamp: int) -> int:
        prev = timestamp - 299
        left = self.sortedlist.bisect_left(prev)
        right = self.sortedlist.bisect_right(timestamp) - 1
        
        # print(self.sortedlist[left : right + 1])
            
        return right - left + 1

# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)