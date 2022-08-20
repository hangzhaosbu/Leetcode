class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < strs.length; ++i)
        {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = String.valueOf(str);
            
            if(!hashmap.containsKey(key))
            {
                hashmap.put(key, new ArrayList<>());
            }
            
            hashmap.get(key).add(strs[i]);
        }
        
        for(String key : hashmap.keySet())
        {
            result.add(hashmap.get(key));
        }
        
        return result;
    }
}