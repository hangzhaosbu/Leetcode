class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        elif n < 0:
            return self.myPow(1/x, -n)
        else:
            
            if n == 1:
                return x
            
            else:
                
                if n % 2 == 0:
                    res = self.myPow(x, n//2)
                    return res * res
                else:
                    res = self.myPow(x, (n-1)//2)
                    return x*res*res
