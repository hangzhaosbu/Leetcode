class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        for i in range(len(points)):
            x, y = points[i][0], points[i][1]
            points[i] = [x**2 + y**2, x, y]
        
        points.sort()
        
        return [[x,y] for _, x, y in points[:k]]