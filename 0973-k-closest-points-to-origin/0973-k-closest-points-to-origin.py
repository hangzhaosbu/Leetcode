class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        for i in range(len(points)):
            points[i] = [points[i][0]*points[i][0]+points[i][1]*points[i][1],points[i][0],points[i][1]]
        
        def quickselect(l, r, k):
            if l == r:
                return [[points[l][1], points[l][2]]]
            
            mid = (r - l) // 2 + l
            pivot = points[mid][0]
            
            i, t, j = l, l, r
            
            while t <= j:
                if points[t][0] < pivot:
                    points[i], points[t] = points[t], points[i]
                    i += 1
                    t += 1
                elif points[t][0] > pivot:
                    points[j], points[t] = points[t], points[j]
                    j -= 1
                else:
                    t += 1
            
            if i - l + 1 == k:
                return [[x[1], x[2]] for x in points[l : i + 1]]
            elif i - l + 1 > k:
                return quickselect(l, i - 1, k)
            else:
                return [[x[1], x[2]] for x in points[l : i + 1]] + quickselect(i + 1, r, k - (i - l + 1))
        
        return quickselect(0, len(points) - 1, k)