class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        
        stack = []
        
        for interval in intervals:
            if not stack:
                stack.append(interval)
            else:
                if stack[-1][1] >= interval[0]:
                    prev = stack.pop()
                    
                    new = [min(prev[0], interval[0]), max(prev[1], interval[1])]
                    stack.append(new)
                else:
                    stack.append(interval)
        
        return stack