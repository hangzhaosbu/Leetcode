class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        
        for c in s:
            if not stack:
                stack.append([c, 1])
            else:
                if stack[-1][0] == c:
                    stack[-1][1] += 1
                    
                    if stack[-1][1] == k:
                        stack.pop()
                else:
                    stack.append([c, 1])
        
        ans = ""
        
        while stack:
            c, l = stack[-1]
            stack.pop()
            
            ans += c*l
        
        return ans[::-1]