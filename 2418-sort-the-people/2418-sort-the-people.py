class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        ret = []
        
        for p, h in zip(names, heights):
            ret.append((h, p))
        
        return [item[1] for item in sorted(ret)[::-1]]