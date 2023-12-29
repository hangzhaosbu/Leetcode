class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        hashset = set()
        
        for email in emails:
            pos = email.find("@")
            pre = email[:pos]
            after = email[pos:]
            
            temp = ""
            
            for letter in pre:
                if letter == '+':
                    break
                if letter != '.':
                    temp += letter
            
            hashset.add(temp + after)
        
        return len(hashset)