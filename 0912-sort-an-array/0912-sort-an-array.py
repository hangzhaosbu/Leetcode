class Solution:
    def mergesort(self, l, r, nums):
        if l >= r:
            return
        
        #1.find the mid
        mid = (l + r) // 2
        
        #2.recursion
        self.mergesort(l, mid, nums)
        self.mergesort(mid + 1, r, nums)
        
        #3.merge
        temp = []
        p1 = l
        p2 = mid + 1
        
        while p1 <= mid and p2 <= r:
            if nums[p1] < nums[p2]:
                temp.append(nums[p1])
                p1 += 1
            else:
                temp.append(nums[p2])
                p2 += 1
        
        while p1 <= mid:
            temp.append(nums[p1])
            p1 += 1
        
        while p2 <= r:
            temp.append(nums[p2])
            p2 += 1
            
        nums[l:r + 1] = temp
        
    
    def sortArray(self, nums: List[int]) -> List[int]:
        self.mergesort(0, len(nums) - 1, nums)
        return nums