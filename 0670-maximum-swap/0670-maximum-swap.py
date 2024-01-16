class Solution:
    def maximumSwap(self, num: int) -> int:
        digits = []
        
        def getD(num):
            
            
            while num > 0:
                digits.append(num % 10)
                num = num // 10
        
        getD(num)
        
        digits = digits[::-1]
        
        for i in range(len(digits)):
            maxIndex = i
            
            for j in range(i + 1, len(digits)):
                if digits[j] >= digits[maxIndex]:
                    maxIndex = j
                    
            if maxIndex != i and digits[maxIndex] != digits[i]:
                digits[i], digits[maxIndex] = digits[maxIndex], digits[i]
                break
        
        ans = 0
        
        for digit in digits:
            ans = ans * 10 + digit
            
        return ans