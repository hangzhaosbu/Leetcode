class Solution:
    def findRLEArray(self, encoded1: List[List[int]], encoded2: List[List[int]]) -> List[List[int]]:
        p1 = 0
        p2 = 0
        
        m, n = len(encoded1), len(encoded2)
        
        ans = []
        
        while p1 < m and p2 < n:
            if encoded1[p1][1] == encoded2[p2][1]:
                if ans and encoded1[p1][0]*encoded2[p2][0] == ans[-1][0]:
                    ans[-1][1] += encoded1[p1][1]
                else:
                    ans.append([encoded1[p1][0]*encoded2[p2][0], encoded1[p1][1]])
                p1 += 1
                p2 += 1
            elif encoded1[p1][1] < encoded2[p2][1]:
                if ans and encoded1[p1][0]*encoded2[p2][0] == ans[-1][0]:
                    ans[-1][1] += encoded1[p1][1]
                else:
                    ans.append([encoded1[p1][0]*encoded2[p2][0], encoded1[p1][1]])
                
                encoded2[p2][1] -= encoded1[p1][1]
                p1 += 1
            else:
                if ans and encoded1[p1][0]*encoded2[p2][0] == ans[-1][0]:
                    ans[-1][1] += encoded2[p2][1]
                else:
                    ans.append([encoded1[p1][0]*encoded2[p2][0], encoded2[p2][1]])
                
                encoded1[p1][1] -= encoded2[p2][1]
                p2 += 1
        
        
        return ans