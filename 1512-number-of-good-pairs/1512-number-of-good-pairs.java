class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        for(Integer key : map.keySet()) ans += (map.get(key) * (map.get(key) - 1)) / 2;
        return ans;
    }
}