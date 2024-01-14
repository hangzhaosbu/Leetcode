class Solution:
    def minStickers(self, stickers: List[str], target: str) -> int:
        stickerCount = []
        
        for i,s in enumerate(stickers):
            stickerCount.append({})
            
            for c in s:
                stickerCount[i][c] = stickerCount[i].get(c, 0) + 1
        
        dp = {} # for each subsequence, the minimum number of stickers that I need to use to spell out that subsequence
        
        def dfs(t, s):
            if t in dp:
                return dp[t]
            
            remain = ""
            res = 1 if s else 0
            
            for c in t:
                if c in s and s[c] > 0:
                    s[c] -= 1
                else:
                    remain += c
            
            
            if remain:
                
                used = float("inf")
                
                for sticker in stickerCount:
                    if remain[0] in sticker:
                        used = min(used, dfs(remain, sticker.copy()))
            
                dp[remain] = used
                res += used
            return res
        
        res = dfs(target, {})
        
        return res if res != float("inf") else -1
                    