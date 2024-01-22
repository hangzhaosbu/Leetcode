class Solution:
    def calculate(self, s: str) -> int:
        curtNum = 0
        prevNum = 0
        ans = 0
        sign = "+"
        # "2*3+2*2"
        for i, c in enumerate(s):
            if c >= '0' and c <= '9':
                curtNum = curtNum * 10 + ord(c) - ord('0')
            
            if c in "+-*/" or i == len(s) - 1:
                
                if sign == "+":
                    ans += prevNum
                    prevNum = curtNum
                elif sign == "-":
                    ans += prevNum
                    prevNum = -curtNum
                    
                elif sign == "*":
                    prevNum = prevNum * curtNum
                else:
                    prevNum = int(prevNum / curtNum)
                
                sign = c
                
                curtNum = 0
                
        if prevNum:
            ans += prevNum
        
        return ans