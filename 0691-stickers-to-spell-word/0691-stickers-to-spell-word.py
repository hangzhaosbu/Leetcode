class Solution:
    def minStickers(self, stickers: List[str], target: str) -> int:
        hashmap = [{} for _ in range(len(stickers))]
        
        for i in range(len(stickers)):
            for c in stickers[i]:
                hashmap[i][c] = hashmap[i].get(c, 0) + 1
        
        dp = {"":0}
        
        def recur(target, dic):
            if target in dp:
                return dp[target]
            
            res = 1 if dic else 0
            temp = ""
            
            for c in target:
                if c in dic and dic[c] > 0:
                    dic[c] -= 1
                else:
                    temp += c
            
            if temp:
                used = float("inf")
                for i, sticker in enumerate(stickers):
                    if temp[0] in sticker:
                        used = min(used, recur(temp, hashmap[i].copy()))

                dp[temp] = used
                res += used
            return res
        
        
        res = recur(target, {})
        
        return res if res != float("inf") else -1
                        