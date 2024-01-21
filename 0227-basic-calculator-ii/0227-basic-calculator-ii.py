class Solution:
    def calculate(self, s: str) -> int:
        prev = 0
        curtNum = 0
        ans = 0
        sign = '+'
        #"2*3+2*2"
        for i, c in enumerate(s):
            
            if ord(c) >= ord('0') and ord(c) <= ord('9'):
                curtNum = curtNum * 10 + (ord(c) - ord('0'))
            
            if c in "+-*/" or i == len(s) - 1:
                
                if sign == "+":
                    ans += prev
                    prev = curtNum
                elif sign == "-":
                    ans += prev
                    prev = -curtNum
                elif sign == "*":
                    prev = prev * curtNum
                elif sign == "/":
                    prev = int(prev / curtNum)
                    
                sign = c
                curtNum = 0
        
        ans += prev
        return ans
                    
                    
                    
            
            
            
            