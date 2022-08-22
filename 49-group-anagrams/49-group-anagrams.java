class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            
            if(!hashmap.containsKey(key))
            {
                hashmap.put(key, new ArrayList<>());
            }
            
            hashmap.get(key).add(str);
        }
        
        for(String key : hashmap.keySet())
        {
            result.add(hashmap.get(key));
        }
        
        return result;
    }
}