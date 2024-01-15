class Solution:
    def isNumber(self, s: str) -> bool:
        symbol, dec, digit, e = False, False, False, False
        
        for c in s:
            if c in "0123456789":
                digit = True
            elif c in "+-":
                if symbol or digit or dec:
                    return False
                else:
                    symbol = True
            elif c in "eE":
                if not digit or e:
                    return False
                else:
                    e = True
                    digit = False
                    symbol = False
                    dec = False
            elif c in '.':
                if dec or e:
                    return False
                else:
                    dec = True
            else:
                return False
        
        return digit