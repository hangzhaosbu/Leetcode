class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        curtNum = 0
        sign = '+'
        #"2*3+2*2"
        for i, c in enumerate(s):
            
            if ord(c) >= ord('0') and ord(c) <= ord('9'):
                curtNum = curtNum * 10 + (ord(c) - ord('0'))
            
            if c in "+-*/" or i == len(s) - 1:
                
                if sign == "+":
                    stack.append(curtNum)
                elif sign == "-":
                    stack.append(-curtNum)
                elif sign == "*":
                    prev = stack[-1] * curtNum
                    stack.pop()
                    
                    stack.append(prev)
                elif sign == "/":
                    prev = int(stack[-1] / curtNum)
                    stack.pop()
                    
                    stack.append(prev)
                    
                sign = c
                curtNum = 0
        
        ans = 0
        
        while stack:
            ans += stack[-1]
            stack.pop()
        
        return ans
                    
                    
                    
            
            
            
            