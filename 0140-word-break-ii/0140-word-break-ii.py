class TrieNode:
    def __init__(self):
        self.next = {}
        self.isWord = False
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add(self, word):
        node = self.root
        for c in word:
            if c not in node.next:
                node.next[c] = TrieNode()
            
            node = node.next[c]
        
        node.isWord = True

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        trie = Trie()
        
        for word in wordDict:
            trie.add(word)
        
        ans = []
        memo = [None for _ in range(len(s))]
        
        def dfs(start, s, curt):
            if start == len(s):
                ans.append(" ".join(curt))
                return True
            
            
            if memo[start] == False:
                return memo[start]
            
            res = False
            
            for i in range(start, len(s)):
                word = s[start:i+1]
                valid = True
                node = trie.root
                for c in word:
                    if c in node.next:
                        node = node.next[c]
                    else:
                        valid = False
                        break
                valid &= node.isWord
                
                if valid:
                    curt.append(word)
                    
                    if dfs(i + 1, s, curt):
                        res = True
                    
                    curt.pop()
            
            memo[start] = res
            return memo[start]
        
        dfs(0, s, [])
        
        return ans
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                