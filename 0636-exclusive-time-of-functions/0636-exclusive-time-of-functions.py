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
                if not stack:
                    stack.append([ID, time, 0])
                else:
                    stack[-1] = [stack[-1][0], time, stack[-1][2] + time - lastTime]
                    stack.append([ID, time, 0])
                
                lastTime = time
                
            else:
                prevID, startTime, Duration = stack[-1][0], stack[-1][1], stack[-1][2]
                stack.pop()
                
                res[ID] += time - lastTime + 1 + Duration
                lastTime = time + 1
        
        return res
                