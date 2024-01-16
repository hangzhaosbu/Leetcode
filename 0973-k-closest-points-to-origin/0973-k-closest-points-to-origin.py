class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        for i in range(len(points)):
            x, y = points[i][0], points[i][1]
            points[i] = [x**2 + y**2, x, y]
        
        
        def quickselect(l, r, points, k):
            if l == r:
                return [[points[l][1], points[l][2]]]
            
            mid = (r - l) // 2 + l
            pivot = points[mid][0]
            
            i = l
            t = l
            j = r
            
            """
            S S S E E E L L L L
            """
            
            while t <= j:
                if points[t][0] < pivot:
                    points[t], points[i] = points[i], points[t]
                    t += 1
                    i += 1
                elif points[t][0] > pivot:
                    points[t], points[j] = points[j], points[t]
                    j -= 1
                else:
                    t += 1
                    
            if j - l + 1 == k:
                return [[x, y] for _, x, y in points[l:j + 1]]
            elif j - l + 1 > k:
                return quickselect(l, j - 1, points, k)
            else:
                return [[x, y] for _, x, y in points[l:j + 1]] + quickselect(j + 1, r, points, k - (j - l + 1))
        
        return quickselect(0, len(points) - 1, points, k)