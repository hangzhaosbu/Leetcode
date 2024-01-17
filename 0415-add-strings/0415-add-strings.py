class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        if len(num1) != len(num2):
            if len(num1) > len(num2):
                num2 = "0" * (len(num1) - len(num2)) + num2
            else:
                num1 = "0" * (len(num2) - len(num1)) + num1
        
        
        n1 = [0 for _ in range(10010)]
        n2 = [0 for _ in range(10010)]
        p = 0
        
        for i in range(len(num1) - 1, -1, -1):
            n1[p] = ord(num1[i]) - ord('0')
            p+=1
        
        p = 0
        for i in range(len(num2) - 1, -1, -1):
            n2[p] = ord(num2[i]) - ord('0')
            p+=1
            
        carry = 0
        
        
        i = 0
        
        while i < len(num1) or i < len(num2):
            carry += n1[i] + n2[i]
            
            n1[i] = carry % 10
            carry = carry // 10
            i+=1
        
        if carry:
            n1[i] = carry
        else:
            i-=1
        
        ans = ""
        
        for j in range(i, -1, -1):
            ans += str(n1[j])
        
        return ans
        