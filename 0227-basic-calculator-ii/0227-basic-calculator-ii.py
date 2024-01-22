class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        
        curtNum = 0
        sign = "+"
        
        for i, c in enumerate(s):
            if c >= '0' and c <= '9':
                curtNum = curtNum * 10 + ord(c) - ord('0')
            
            
            if c in "+-*/" or i == len(s) - 1:
                
                if sign == "+":
                    stack.append(curtNum)
                elif sign == "-":
                    stack.append(-curtNum)
                    
                elif sign == "*":
                    stack[-1] = stack[-1] * curtNum
                else:
                    stack[-1] = int(stack[-1] / curtNum)
                
                sign = c
                curtNum = 0
                
        ans = 0
        
        while stack:
            ans += stack[-1]
            stack.pop()
        
        return ans