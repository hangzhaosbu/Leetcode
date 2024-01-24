class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        hashmap = {}
        ans = []
        
        
        for string in strings:
            
            if string[0] == 'a':
                if string not in hashmap:
                    hashmap[string] = []
                hashmap[string].append(string)
            else:
                diff = ord(string[0]) - ord('a')
                curt = ""
                
                for c in string:
                    
                    if ord(c) - diff >= 97:
                        curt += chr(ord(c) - diff)
                    else:
                        
                        curt += chr(ord(c) - diff + 26)
                
                if curt not in hashmap:
                    hashmap[curt] = []
                
                hashmap[curt].append(string)
        
        for key, val in hashmap.items():
            ans.append(val)
        
        return ans
                