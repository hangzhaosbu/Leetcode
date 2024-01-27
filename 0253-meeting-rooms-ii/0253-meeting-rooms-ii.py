class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        starts = []
        ends = []
        
        for interval in intervals:
            starts.append(interval[0])
            ends.append(interval[1])
        
        starts.sort()
        ends.sort()
        
        p1 = 0
        
        count = 0
        ans = 0
        
        
        for start in starts:
            count += 1
            
            if start >= ends[p1]:
                count -= 1
                p1 += 1
            
            ans = max(ans, count)
        
        return ans