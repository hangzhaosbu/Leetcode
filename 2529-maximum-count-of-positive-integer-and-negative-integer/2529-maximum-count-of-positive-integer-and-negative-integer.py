class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        maxneg=0
        maxpos=0
        l=0
        r=len(nums)-1
        
        if nums[0]>0 or nums[len(nums) - 1] < 0:
            return len(nums)
        
        while l<= r:
            mid=(l+r)//2
            if nums[mid]<0 and nums[mid+1]>=0:
                maxneg=mid+1
                break
            elif nums[mid]<0 and nums[mid+1]<=-1:
                l=mid+1
            else:
                r=mid-1
        
        l=0
        r=len(nums)-1
        while l<= r:
            mid=(l+r)//2
            if nums[mid]>0 and nums[mid-1]<=0:
                maxpos=len(nums[mid:len(nums)])
                break
            elif nums[mid]<=0:
                l=mid+1
            else:
                r=mid-1
        if maxneg>maxpos:
            return maxneg
        else:
            return maxpos