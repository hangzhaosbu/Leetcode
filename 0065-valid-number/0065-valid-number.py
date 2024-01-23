class Solution:
    def isNumber(self, s: str) -> bool:
        """
        ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
        """
        num, dec, e, sign = False, False, False, False
        
        for c in s:
            if c in "+-":
                if sign or num or dec:
                    return False
                sign = True
                
            elif c in "0123456789":

                num = True
                
            elif c == '.':
                if dec or e:
                    return False
                
                dec = True
            
            elif c in "eE":
                if e or not num:
                    return False
                dec = False
                num = False
                sign = False
                e = True
            
            else:
                return False
        
        
        return num