class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        lastEnd = 0
        res = [0 for _ in range(n)]
        stack = []
        
        for log in logs:
            log = log.split(":")
            id = int(log[0])
            info = log[1]
            time = int(log[2])
            
            if info == "start":
                
                if stack:
                    res[stack[-1]] += time - lastEnd
                stack.append(id)
                lastEnd = time
            else:
                res[stack[-1]] += time - lastEnd + 1
                lastEnd = time + 1
                stack.pop()
        
        return res