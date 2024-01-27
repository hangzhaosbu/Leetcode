class Solution:
    hashmap = {"2":"abc", "3":"def", "4":"ghi", "5":"jkl","6":"mno", "7":"pqrs","8":"tuv","9":"wxyz"}
    
    
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        if len(digits) == 1:
            return [x for x in self.hashmap[digits[0]]]

        mid = len(digits) // 2
        
        left = self.letterCombinations(digits[:mid])
        right = self.letterCombinations(digits[mid:])
        
        ans = []
        for l in left:
            for r in right:
                ans.append(l + r)
        
        return ans