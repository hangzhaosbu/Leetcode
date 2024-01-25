class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        carry = 0
        ans = ""
        
        p1 = len(num1) - 1
        p2 = len(num2) - 1
        
        while p1 >= 0 or p2 >= 0:
            if p1 >= 0:
                carry += ord(num1[p1]) - ord('0')
            
            if p2 >= 0:
                carry += ord(num2[p2]) - ord('0')
                
            ans = str(carry % 10) + ans
            
            carry = carry//10
            
            p2 -= 1
            p1 -= 1
        
        if carry:
            ans = str(carry % 10) + ans
        
        return ans