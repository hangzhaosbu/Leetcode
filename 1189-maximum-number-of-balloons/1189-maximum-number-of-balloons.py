class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        hashmap = {}
        
        for c in "balloon":
            hashmap[c] = 0
        
        for c in text:
            if c not in hashmap:
                hashmap[c] = 1
            else:
                hashmap[c] += 1
            
        count = 0
        
        while True:
            
            if hashmap['b'] > 0 and hashmap['a'] > 0 and hashmap['l'] > 1 and hashmap['o'] > 1 and hashmap['n'] > 0:
                hashmap['b'] -= 1
                hashmap['a'] -= 1
                hashmap['l'] -= 2
                hashmap['o'] -= 2
                hashmap['n'] -= 1
                count += 1
            else:
                break
        return count
                
                