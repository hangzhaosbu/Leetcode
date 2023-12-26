class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        """
        "" - "flower"
        0,1,2,3,4,5
        candidate[0:0] -> ""
        candidate[0:1] -> "f"
        candidate[0:2] -> "fl"
        candidate[0:3] -> "flo"
        candidate[0:4] -> "flow"
        candidate[0:5] -> "flowe"
        candidate[0:6] -> "flower"
        """
        
        # if len(strs) == 1:
        #     return strs[0]
        
        candidate = strs[0]
        ans = ""
        
        for length in range(0, len(candidate) + 1):
            prefix = candidate[0:length]
            count = 0
            
            for string in strs:
                if string.startswith(prefix):
                    count += 1
            
            if count == len(strs):
                if len(prefix) > len(ans):
                    ans = prefix
        
        return ans