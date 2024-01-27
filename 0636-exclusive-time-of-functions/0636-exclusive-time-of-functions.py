class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0 for _ in range(n)]
        stack = []
        endTime = 0
        
        for log in logs:
            log = log.split(":")
            ID = int(log[0])
            status = log[1]
            time = int(log[2])
            
            if status == "start":
                if stack:
                    stack[-1] = stack[-1] + time - lastTime
                stack.append(0)
                lastTime = time
                
            else:
                duration = stack.pop()
                res[ID] += time - lastTime + 1 + duration
                lastTime = time + 1
        
        return res
                