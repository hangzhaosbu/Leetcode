from sortedcontainers import SortedList
class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        a1, a2 = [nums[0]], [nums[1]]
        h1, h2 = SortedList(), SortedList()
        h1.add(nums[0])
        h2.add(nums[1])
        def greaterCount(arr, num, h):
            l = h.bisect_right(num)
            return len(h) - l
        
        for i in range(2, len(nums)):
            num = nums[i]
            c1 = greaterCount(a1, num, h1)
            c2 = greaterCount(a2, num, h2)
            
            if c1 > c2:
                a1.append(num)
                h1.add(num)
            elif c1 < c2:
                a2.append(num)
                h2.add(num)
            else:
                if len(a1) <= len(a2):
                    a1.append(num)
                    h1.add(num)
                else:
                    a2.append(num)
                    h2.add(num)
        
        return a1 + a2
            