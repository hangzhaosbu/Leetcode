class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        ans = []
        stack = []
        
        A = A + B
        A.sort()
        
        for interval in A:
            if not stack:
                stack.append(interval)
            else:
                if interval[0] <= stack[-1][1]:
                    ans.append([max(interval[0], stack[-1][0]), min(stack[-1][1], interval[1])])
                    interval = [stack[-1][0], max(interval[1], stack[-1][1])]
                stack.pop()
                stack.append(interval)
        
        return ans
        