class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        stack = []
        intervals.sort()
        
        for interval in intervals:
            if not stack:
                stack.append(interval)
            else:
                if stack[-1][1] >= interval[0]:
                    interval = [stack[-1][0], max(stack[-1][1], interval[1])]
                    stack.pop()
                stack.append(interval)
        return stack