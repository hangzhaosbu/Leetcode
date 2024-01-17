class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        hashmap = {}
        
        for num in arr:
            hashmap[num] = hashmap.get(num, 0) + 1
        
        return len(set(hashmap.values())) == len(hashmap.values())