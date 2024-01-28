class Solution:
    def taskSchedulerII(self, tasks: List[int], space: int) -> int:
        hashmap = {}
        cur = 0
        
        for task in tasks:
            if task in hashmap:
                cur = max(cur, hashmap[task])
            
            hashmap[task] = cur + space + 1
            cur += 1
        
        return cur